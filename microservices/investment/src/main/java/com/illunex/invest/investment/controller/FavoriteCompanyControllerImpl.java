package com.illunex.invest.investment.controller;

import com.illunex.invest.api.core.investment.controller.FavoriteCompanyController;
import com.illunex.invest.api.core.investment.dto.FavoriteCompanyDTO;
import com.illunex.invest.api.core.investment.dto.ListDTO;
import com.illunex.invest.investment.service.FavoriteCompanyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FavoriteCompanyControllerImpl implements FavoriteCompanyController {
    private Log log = LogFactory.getLog(FavoriteCompanyControllerImpl.class);

    final FavoriteCompanyService favoriteCompanyService;

    public FavoriteCompanyControllerImpl(FavoriteCompanyService favoriteCompanyService) {
        this.favoriteCompanyService = favoriteCompanyService;
    }

    @Override
    public ResponseEntity<ListDTO> getFavoriteCompanyList(Long userIdx) {
        return new ResponseEntity(favoriteCompanyService.getFavoriteCompanyList(userIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FavoriteCompanyDTO> getFavoriteCompany(Long companyIdx) {
        return new ResponseEntity(favoriteCompanyService.getFavoriteCompany(companyIdx), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> setFavoriteCompanyList(FavoriteCompanyDTO favoriteCompanyDTO) {
        return new ResponseEntity(favoriteCompanyService.setFavoriteCompany(favoriteCompanyDTO), HttpStatus.OK);
    }

}

