package com.resasncf.ResaSncf.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.resasncf.ResaSncf.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository <Role, Long> {
    Optional<Role> findByUser_Id(Long userId);
}
