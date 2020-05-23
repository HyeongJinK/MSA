package com.illunex.invest.user.persistence.repository;

import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.custom.UserRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    List<User> findAllByCompanyIdx(Long companyIdx);
    User findByUsername(String username);
    User findByToken(String token);
}
