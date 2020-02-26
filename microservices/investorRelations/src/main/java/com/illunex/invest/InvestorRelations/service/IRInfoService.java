package com.illunex.invest.InvestorRelations.service;

public interface IRInfoService<T> {

    public T get(Long id);
    public T edit(T t);
}