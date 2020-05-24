package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Plugin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PluginRepository extends JpaRepository<Plugin, Long> {
    List<Plugin> findByCompanyCompanyIdxOrderByProductIdAsc(Long companyIdx);
}
