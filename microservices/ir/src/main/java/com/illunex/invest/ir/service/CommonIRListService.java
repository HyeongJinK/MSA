package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;

import java.util.List;

public interface CommonIRListService<T> {
    public ListDTO getList(Long irIdx);
    public String editList(Long irIdx, List<T> infoList);
}