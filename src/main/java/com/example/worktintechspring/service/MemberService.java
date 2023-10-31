package com.example.worktintechspring.service;

import com.example.worktintechspring.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MemberService implements UserDetailsService {
    private MemberDao memberDao;

    @Autowired
    public MemberService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberDao.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Please enter a valid email"));
    }
}
