package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.*;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Product;
import com.illunex.invest.company.persistence.entity.VcFavoriteCompany;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import com.illunex.invest.company.persistence.repository.VcFavoriteCompanyRepository;
import com.illunex.invest.company.service.mapper.VcCompanyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Log
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class VcCompanyServiceImpl implements VcCompanyService {
    private VcCompanyMapper vcMapper = Mappers.getMapper(VcCompanyMapper.class);
    private final CompanyRepository companyRepository;
    private final VcFavoriteCompanyRepository vcFavoriteCompanyRepository;

    @Override
    public List<VcCompanyDTO> getVcCompanyList() {
        return vcMapper.vcCompanyEntityListToDTO(companyRepository.findAll());
    }

    @Override
    public VcCompanyDetailDTO getVcCompanyDetail(Long companyIdx) {
        Company company = companyRepository.findById(companyIdx).get();
        VcProductDTO product = VcProductDTO.builder().build();
        int index=0;

        for (Product p : company.getProducts()) {
            index++;
            if (p.getRepresentation()) {
                product.setTitle(p.getTitle());
                product.setProductImages(vcMapper.productImageEntityListToDTO(p.getProductImages()));
            } else {
                if (index == 0) {
                    product.setTitle(p.getTitle());
                    product.setProductImages(vcMapper.productImageEntityListToDTO(p.getProductImages()));
                }
            }
        }

        return VcCompanyDetailDTO.builder()
            .companyIdx(company.getCompanyIdx())
            .logo(vcMapper.entityToDto(company.getLogo()))
            .name(company.getName())
            .companyType(company.getCompanyType())
            .establishmentDate(company.getEstablishmentDate())
            .employeeCount(company.getEmployeeCount())
            .business(company.getBusiness())
            .nation(company.getNation())
            .stocksList(company.getStocksList())
            .address(vcMapper.entityToDto(company.getAddress()))
            .sales(vcMapper.entitySalesListToDto(company.getSales()))
            .product(product)
            .build();
    }

    @Override
    public VcFavoriteCompanyListDTO getVcFavoriteCompanyList(Long userIdx) {
        List<VcFavoriteCompany> vcFavoriteCompanyList = vcFavoriteCompanyRepository.findAllByUserIdx(userIdx);

        List<Long> favoriteCompanyList = new ArrayList();

        for (VcFavoriteCompany v : vcFavoriteCompanyList) {
            favoriteCompanyList.add(v.getCompanyIdx());
        }

        return VcFavoriteCompanyListDTO.builder()
                .vcCompanyList(vcMapper.vcCompanyEntityListToDTO(companyRepository.findByCompanyIdxIn(favoriteCompanyList)))
                .vcFavoriteCompanyList(vcMapper.vcFavoriteCompanyListEntityToDTO(vcFavoriteCompanyList))
                .build();
    }

    @Override
    public VcFavoriteCompanyDTO getFavoriteCompany(Long companyIdx) {
        return vcMapper.vcFavoriteCompanyEntityToDTO(vcFavoriteCompanyRepository.findByCompanyIdx(companyIdx));
    }

    @Override
    public String setFavoriteCompany(VcFavoriteCompanyDTO vcFavoriteCompanyDTO) {

        VcFavoriteCompany favoriteCompany = vcFavoriteCompanyRepository.findByCompanyIdx(vcFavoriteCompanyDTO.getCompanyIdx());

        if (favoriteCompany == null) {
            VcFavoriteCompany newFavoriteCompany = VcFavoriteCompany.builder()
                    .userIdx(vcFavoriteCompanyDTO.getUserIdx())
                    .companyIdx(vcFavoriteCompanyDTO.getCompanyIdx())
                    .registrationDate(LocalDateTime.now())
                    .build();

            vcFavoriteCompanyRepository.save(newFavoriteCompany);
            return "Favorite Company Register Success";
        } else {
            vcFavoriteCompanyRepository.delete(favoriteCompany);
            return "Favorite Company Unregister Success";
        }
    }


}
