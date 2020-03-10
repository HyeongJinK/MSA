package com.illunex.invest.ir.service;

import com.illunex.invest.ir.persistence.entity.BasicInfoEntity;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CommonIRService<T> {
    @Autowired IRRepository irRepository;

    abstract public T get(Long irIdx);
    abstract public String edit(T info);
    protected String editTemplate(IREntity ir, Runnable runnable, String success, String fail) {
        if (ir == null) {
            return success;
        } else {
            runnable.run();

            ir.progressCalculate();
            irRepository.save(ir);

            return fail;
        }
    }
}