package com.example.worktintechspring.service;

import com.example.worktintechspring.dao.AccountDao;
import com.example.worktintechspring.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService {
   private AccountDao accountDao;

   @Autowired
    public AccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public List<Account> findAll (){
       return accountDao.findAll();

    }
    public Account findById (Long id){
        Optional<Account> optionalAccount = accountDao.findById(id);
        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }
       throw new RuntimeException("There is no Account with given id");
    }

    public Account save (Account account){

       return accountDao.save(account);
    }
    public Account update(long id , Account account){
      Account updatedAccount = findById(id);
       updatedAccount.setName(account.getName());
       return updatedAccount ;
    }
}
