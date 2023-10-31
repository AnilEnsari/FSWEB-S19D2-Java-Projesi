package com.example.worktintechspring.controller;


import com.example.worktintechspring.dto.RegisterRequest;
import com.example.worktintechspring.entity.Member;
import com.example.worktintechspring.service.MemberService;
import com.example.worktintechspring.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class RoleController {

    private RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping("/register")
    public Member register (@RequestBody RegisterRequest registerRequest){
      return  roleService.register(registerRequest.email(), registerRequest.password());
    }
}
