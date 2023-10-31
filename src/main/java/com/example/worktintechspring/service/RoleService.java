package com.example.worktintechspring.service;


import com.example.worktintechspring.dao.MemberDao;
import com.example.worktintechspring.dao.RoleDao;
import com.example.worktintechspring.entity.Member;
import com.example.worktintechspring.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService  {
    private MemberDao memberDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RoleService(MemberDao memberDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.memberDao = memberDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }
    public Member register(String email, String password){
    Optional<Member> emailCheckedMember =  memberDao.findByEmail(email);
    if(emailCheckedMember.isPresent()){
        throw new RuntimeException("Email already exists "+email);
    } else {

        List <Role>roleList = new ArrayList<>();
        Role role = roleDao.findByAuthority("USER").get();
        roleList.add(role);
        String codedPassword = passwordEncoder.encode(password);
        Member newMember = new Member();
        newMember.setEmail(email);
        newMember.setPassword(codedPassword);
        newMember.setAuthorities(roleList);
        return memberDao.save(newMember);
    }



    }


}
