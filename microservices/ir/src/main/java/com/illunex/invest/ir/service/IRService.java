package com.illunex.invest.ir.service;

import com.illunex.invest.ir.persistence.entity.*;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import com.illunex.invest.ir.service.mapper.IRMapper;
import com.illunex.invest.api.core.ir.dto.IRDTO;
import com.illunex.invest.api.core.ir.dto.ListDTO;
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

    public ListDTO getIRList(Long companyIdx) {
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
                    .progress("0")
                    .readCount(0)
                    .updateDate(LocalDateTime.now())
                    .year(year)
                    .build();
            basicInfoEntity.setIr(irEntity);

            irRepository.save(irEntity);
        }
        List<IRDTO> result = irMapper.entityListToDtoList(irRepository.findAllByCompanyIdx(companyIdx));
        return ListDTO.builder().irList(result).build();
    }

    public IRDTO getIR(Long companyIdx, String year) {
        return irMapper.entityToDto(irRepository.findByCompanyIdxAndYear(companyIdx, year));
    }

    private String setColor() {
        return "#00bff3";
    }

    public String changeCardColor(Long irIdx, String color) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();

            irEntity.setCardColor(color);
            irRepository.save(irEntity);
            return "CardColor set complete";
        } catch (Exception ex) {
            return "Cannot change card color. Invalid IR Index.";
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

    public String resetPassword(Long irIdx) {
        try {
            IREntity irEntity = irRepository.findById(irIdx).get();
            irEntity.setPassword("");
            irEntity.setIsPassword(false);
            irRepository.save(irEntity);

            return "Password reset complete";
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
