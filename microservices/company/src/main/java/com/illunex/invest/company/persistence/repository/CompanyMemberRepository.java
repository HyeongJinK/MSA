package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.CompanyMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyMemberRepository extends JpaRepository<CompanyMember, Long> {
}
