package com.illunex.invest.investment.service;

import com.illunex.invest.api.core.investment.dto.FavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.investment.persistence.entity.FavoriteCompany;
import com.illunex.invest.investment.persistence.repository.FavoriteCompanyRepository;
import com.illunex.invest.investment.service.mapper.InvestMentMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FavoriteCompanyService {
    private Log log = LogFactory.getLog(FavoriteCompanyService.class);

    @Autowired FavoriteCompanyRepository favoriteCompanyRepository;

    private InvestMentMapper mapper = Mappers.getMapper(InvestMentMapper.class);

    public ListDTO getFavoriteCompanyList(Long userIdx) {
        return ListDTO.builder().favoriteCompanyList(mapper.favoriteCompanyListEntityToDTO(favoriteCompanyRepository.findAllByUserIdx(userIdx))).build();
    }

    public FavoriteCompanyDTO getFavoriteCompany(Long companyIdx) {
        return mapper.favoriteCompanyEntityToDTO(favoriteCompanyRepository.findByCompanyIdx(companyIdx));
    };

    public String setFavoriteCompany(FavoriteCompanyDTO favoriteCompanyDTO) {

        FavoriteCompany favoriteCompany = favoriteCompanyRepository.findByCompanyIdx(favoriteCompanyDTO.getCompanyIdx());

        if (favoriteCompany == null) {
            FavoriteCompany newFavoriteCompany = FavoriteCompany.builder()
                    .userIdx(favoriteCompanyDTO.getUserIdx())
                    .companyIdx(favoriteCompanyDTO.getCompanyIdx())
                    .registrationDate(LocalDateTime.now())
                    .build();

            favoriteCompanyRepository.save(newFavoriteCompany);
            return "Favorite Company Register Success";
        } else {
            favoriteCompanyRepository.delete(favoriteCompany);
            return "Favorite Company Unregister Success";
        }
    }

}
