package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.repository.InvestorRelationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InvestorRelationsService {
    @Autowired
    InvestorRelationsRepository investorRelationsRepository;
}
