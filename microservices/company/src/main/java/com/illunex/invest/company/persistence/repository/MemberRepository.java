package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByCompanyCompanyIdx(Long companyIdx);
    void deleteByCompanyCompanyIdx(Long companyIdx);
}
