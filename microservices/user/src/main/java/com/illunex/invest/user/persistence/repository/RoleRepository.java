package com.illunex.invest.user.persistence.repository;

import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.repository.custom.RoleCustomRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>, RoleCustomRepository {
}
