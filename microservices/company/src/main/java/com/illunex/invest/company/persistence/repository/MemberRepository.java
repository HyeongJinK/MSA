package com.illunex.invest.company.persistence.repository;

import com.illunex.invest.company.persistence.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
