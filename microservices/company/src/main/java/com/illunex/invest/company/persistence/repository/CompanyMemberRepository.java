package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CompanyMemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMemberRepository extends JpaRepository<CompanyMemberEntity, Long> {
}
