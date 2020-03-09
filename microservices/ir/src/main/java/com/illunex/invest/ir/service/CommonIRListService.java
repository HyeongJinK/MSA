package com.illunex.invest.ir.service;

import java.util.List;

public interface CommonIRListService<T> {
    public List<T> getList(Long irIdx);
    public String editList(Long irIdx, List<T> infoList);
}