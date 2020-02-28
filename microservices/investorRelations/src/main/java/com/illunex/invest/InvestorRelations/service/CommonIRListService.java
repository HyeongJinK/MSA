package com.illunex.invest.InvestorRelations.service;

import java.util.List;

public interface CommonIRListService<T> {
    public List<T> getList(Long irIdx);
    public List<T> editList(List<T> infoList);
}