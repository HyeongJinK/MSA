package com.illunex.invest.ir.service;

import com.illunex.invest.api.core.ir.dto.ListDTO;
import com.illunex.invest.ir.persistence.entity.IREntity;
import com.illunex.invest.ir.persistence.repository.IRRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class CommonIRListService<T> {
    @Autowired IRRepository irRepository;

    abstract public ListDTO getList(Long irIdx);
    abstract public String editList(Long irIdx, List<T> infoList);
    protected String editTemplate(IREntity ir, Runnable runnable, String fail, String success) {
        if (ir == null) {
            return fail;
        } else {
            runnable.run();

            ir.progressCalculate();
            irRepository.save(ir);

            return success;
        }
    }
}