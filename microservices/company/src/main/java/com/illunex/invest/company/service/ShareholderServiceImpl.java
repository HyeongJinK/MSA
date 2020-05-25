package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.company.persistence.entity.Shareholder;
import com.illunex.invest.company.persistence.repository.ShareholderRepository;
import com.illunex.invest.company.service.mapper.ShareholderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Log
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShareholderServiceImpl implements ShareholderService {
    private ShareholderMapper mapper = Mappers.getMapper(ShareholderMapper.class);
    private final ShareholderRepository shareholderRepository;

    @Override
    public List<ShareholderDTO> findByCompanyIdx(Long companyIdx) {
        return mapper.entityToDto(shareholderRepository.findByCompanyCompanyIdx(companyIdx));
    }

    @Override
    public ShareholderDTO findById(Long id) {
        Shareholder shareholder = shareholderRepository.findById(id).get();
        //log.info(shareholder.toString());
        return mapper.entityToDto(shareholder);
    }

    @Override
    @Transactional
    public void edit(ShareholderDTO shareholderDTO) {
        shareholderRepository.save(mapper.dtoToEntity(shareholderDTO));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        shareholderRepository.deleteById(id);
    }
}
