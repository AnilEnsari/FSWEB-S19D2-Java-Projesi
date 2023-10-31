package com.example.worktintechspring.controller;


import com.example.worktintechspring.entity.Account;
import com.example.worktintechspring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll (){

        return  accountService.findAll();
    }
    @GetMapping("/{id}")
    public  Account find(@PathVariable long id){
        return accountService.findById(id);
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account){

      return   accountService.save(account);
    }

    @PutMapping("/{id}")
    public  Account update (@PathVariable long id,@RequestBody Account account){

      return   accountService.update(id,account);

    }
}
