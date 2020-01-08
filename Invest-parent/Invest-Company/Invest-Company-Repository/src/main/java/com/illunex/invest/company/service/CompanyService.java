package com.illunex.invest.company.service;

import com.illunex.invest.company.repository.CompanyMemberRepository;
import com.illunex.invest.company.repository.CompanyProductRepository;
import com.illunex.invest.company.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired CompanyRepository companyRepository;
    @Autowired CompanyProductRepository companyProductRepository;
    @Autowired CompanyMemberRepository companyMemberRepository;
}
