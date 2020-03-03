package com.illunex.invest.InvestorRelations.service;

import com.illunex.invest.InvestorRelations.persistence.entity.*;
import com.illunex.invest.InvestorRelations.persistence.repository.IRRepository;
import com.illunex.invest.InvestorRelations.service.mapper.IRMapper;
import com.illunex.invest.api.core.InvestorRelations.dto.IRDTO;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class IRService {
    private Log log = LogFactory.getLog(IRService.class);
    private IRMapper irMapper = Mappers.getMapper(IRMapper.class);

    @Autowired
    IRRepository irRepository;

    public List<IRDTO> getList(Long companyIdx) {
        String year = String.valueOf(LocalDateTime.now().getYear());
        IREntity currentYearIR = irRepository.findByCompanyIdxAndYear(companyIdx, year);

        if (currentYearIR == null) {
            BasicInfoEntity basicInfoEntity = BasicInfoEntity.builder()
                    .build();
            FinanceEntity financeEntity = FinanceEntity.builder()
                    .build();
            ProductEntity productEntity = ProductEntity.builder()
                    .build();
            OutcomeEntity outcomeEntity = OutcomeEntity.builder()
                    .build();
            IREntity irEntity = IREntity.builder()
                    .companyIdx(companyIdx)
                    .cardColor(setColor())
                    .basicInfo(basicInfoEntity)
                    .finance(financeEntity)
                    .product(productEntity)
                    .outcome(outcomeEntity)
                    .isPassword(false)
                    .readCount(0)
                    .updateDate(LocalDateTime.now())
                    .year(year)
                    .build();
            basicInfoEntity.setIr(irEntity);

            irRepository.save(irEntity);
        }
        return irMapper.entityListToDtoList(irRepository.findAllByCompanyIdx(companyIdx));
    }

    private String setColor() {
        return "#000000";
    }

    public IRDTO changeCardColor(Long irIdx, String color) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();

            irEntity.setCardColor(color);
            irRepository.save(irEntity);

            return irMapper.entityToDto(irEntity);
        } catch (Exception ex) {
            return IRDTO.builder().cardColor("unavailable").build();
        }
    }

    public String setPassword(Long irIdx, String password) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();

            PasswordEncoding passwordEncoding = new PasswordEncoding();
            String encodedPassword = passwordEncoding.encode(password);

            irEntity.setPassword(encodedPassword);
            irEntity.setIsPassword(true);
            irRepository.save(irEntity);

            return "Password set complete";
        } catch (Exception ex) {
            return "unavailable";
        }
    }

    public String confirmPassword(Long irIdx, String password) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();
            PasswordEncoding passwordEncoding = new PasswordEncoding();

            if (passwordEncoding.matches(password, irEntity.getPassword())) {
                return "Password confirm complete";
            } else {
                return "Invalid password";
            }
        } catch (Exception ex){
            return "Invalid IR Index";
        }
    }

    public String changePassword(Long irIdx, String currentPassword, String newPassword) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();
            PasswordEncoding passwordEncoding = new PasswordEncoding();

            if (passwordEncoding.matches(currentPassword, irEntity.getPassword())) {
                String encodedPassword = passwordEncoding.encode(newPassword);

                irEntity.setPassword(encodedPassword);
                irRepository.save(irEntity);

                return "Password change complete";
            } else {
                return "Invalid password";
            }
        } catch (Exception ex){
            return "Invalid IR Index";
        }
    }

}
