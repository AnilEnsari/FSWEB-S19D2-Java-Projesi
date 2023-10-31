package com.example.worktintechspring.dao;

import com.example.worktintechspring.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AccountDao extends JpaRepository<Account,Long> {

}
