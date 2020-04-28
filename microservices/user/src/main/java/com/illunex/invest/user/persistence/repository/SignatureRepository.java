package com.illunex.invest.user.persistence.repository;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import com.illunex.invest.user.persistence.entity.Signature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SignatureRepository extends JpaRepository<Signature, Long> {
    List<Signature> findByUserId(Long userId);
    List<Signature> findByUserIdAndStatus(Long userId, SignatureStatus status);
}
