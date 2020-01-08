package com.illunex.invest.company.repository;

import com.illunex.invest.company.entity.CompanyMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyMemberRepository extends JpaRepository<CompanyMember, Long> {
}
