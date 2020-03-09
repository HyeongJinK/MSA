package com.illunex.invest.ir.service;

import java.util.List;

public interface CommonIRService<T> {
    public T get(Long irIdx);
    public String edit(T info);
}