package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.CompanyDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyDTO;
import com.illunex.invest.api.core.company.dto.VcCompanyDetailDTO;
import com.illunex.invest.api.core.company.dto.VcProductDTO;
import com.illunex.invest.api.core.investment.dto.FavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.company.exception.NoneCompanyException;
import com.illunex.invest.company.persistence.entity.Company;
import com.illunex.invest.company.persistence.entity.Product;
import com.illunex.invest.company.persistence.repository.CompanyRepository;
import com.illunex.invest.company.service.mapper.CompanyMapper;
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
public class CompanyServiceImpl implements CompanyService {
    private CompanyMapper mapper = Mappers.getMapper(CompanyMapper.class);
    private VcCompanyMapper vcMapper = Mappers.getMapper(VcCompanyMapper.class);
    private final CompanyRepository companyRepository;

    @Override
    public List<CompanyDTO> getAllList() {
        return mapper.entityListToDto(companyRepository.findAll());
    }

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
            .logo(company.getLogo())
            .name(company.getName())
            .companyType(company.getCompanyType())
            .establishmentDate(company.getEstablishmentDate())
            .employeeCount(company.getEmployeeCount())
            .business(company.getBusiness())
            .nation(company.getNation())
            .stocksList(company.getStocksList())
            .description(company.getDescription())
            .sales(company.getSales())
            .product(product)
            .build();
    }

    public CompanyDTO getCompanyById(final Long id) {
        Company company = companyRepository.findByCompanyIdx(id).orElseGet(() -> {
            throw new NoneCompanyException(id.toString());
        });
        log.info(company.toString());
        return mapper.entityToDto(company);
    }

    @Override
    @Transactional
    public Long registerCompany(String businessNumber) {
        return companyRepository.save(Company.builder()
                .businessNumber(businessNumber)
                .build()).getCompanyIdx();
    }

    @Override
    @Transactional
    public CompanyDTO updateCompany(CompanyDTO companyDTO) {
        companyDTO.setUpdateDate(LocalDateTime.now());
        log.info(companyDTO.toString());
        return mapper.entityToDto(companyRepository.save(mapper.dtoToEntity(companyDTO)));
    }

    @Override
    public List<VcCompanyDTO> getFavoriteCompanyList(ListDTO listDTO) {
        List<Company> list = new ArrayList<>();
        for (FavoriteCompanyDTO f: listDTO.getFavoriteCompanyList()) {
            list.add(companyRepository.findByCompanyIdx(f.getCompanyIdx()).get());
        }
        return vcMapper.vcCompanyEntityListToDTO(list);
    }
}
