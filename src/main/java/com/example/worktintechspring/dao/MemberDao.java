package com.example.worktintechspring.dao;

import com.example.worktintechspring.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface MemberDao extends JpaRepository<Member,Long> {

    @Query(value = "SELECT m.id,m.email,m.password from fsweb.member as m WHERE m.email=:email",nativeQuery = true)
    Optional<Member> findByEmail(String email);

}
