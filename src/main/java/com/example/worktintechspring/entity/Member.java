package com.example.worktintechspring.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name="member",schema = "fsweb")

public class Member {
   @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private long id;
   @Column(name = "email")
   private String email;

   @Column (name = "password")
   private String password;

   @ManyToMany (fetch = FetchType.EAGER)
   @JoinTable(name= "member_role",schema ="fsweb",
           joinColumns = @JoinColumn(name ="member_id"),
           inverseJoinColumns = @JoinColumn(name = "role_id"))
  private List<Role> authorityList ;
}
