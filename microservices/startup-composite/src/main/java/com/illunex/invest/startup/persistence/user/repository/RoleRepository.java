package com.illunex.invest.startup.persistence.user.repository;


import com.illunex.invest.startup.persistence.user.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
