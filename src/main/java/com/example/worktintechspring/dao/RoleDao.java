package com.example.worktintechspring.dao;

import com.example.worktintechspring.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RoleDao extends JpaRepository <Role,Long>{
    @Query("SELECT r FROM Role r WHERE r.authority=:authority")
     Optional<Role> findByAuthority(String authority);
}
