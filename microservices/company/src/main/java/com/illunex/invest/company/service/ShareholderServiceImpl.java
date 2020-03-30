package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ShareholderDTO;
import com.illunex.invest.company.persistence.repository.ShareholderRepository;
import com.illunex.invest.company.service.mapper.ShareholderMapper;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        return mapper.entityToDto(shareholderRepository.findById(id).get());
    }

    @Override
    @Transactional
    public void edit(ShareholderDTO shareholderDTO) {
        shareholderRepository.save(mapper.dtoToEntity(shareholderDTO));
    }

    @Override
    public void delete(Long id) {
        shareholderRepository.deleteById(id);
    }
}
