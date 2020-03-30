package com.illunex.invest.company.service;

import com.illunex.invest.api.core.company.dto.ShareholderDTO;

import java.util.List;

public interface ShareholderService {
    List<ShareholderDTO> findByCompanyIdx(Long companyIdx);
    ShareholderDTO findById(Long id);
    void edit(ShareholderDTO shareholderDTO);
    void delete(Long id);
}
