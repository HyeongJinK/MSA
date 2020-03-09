package com.illunex.invest.ir.service;

import java.util.List;

public interface CommonIRService<T> {
    public T get(Long irIdx);
    public T edit(T info);
}