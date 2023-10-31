package com.example.worktintechspring.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain filterChain( HttpSecurity http) throws Exception{
         
        return http.csrf(csrf->csrf.disable())
                .authorizeHttpRequests(auth->{
                    auth.requestMatchers("/auth/**").permitAll();
                    auth.requestMatchers(HttpMethod.POST,"/account/**").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT,"/account/**").hasAuthority("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE,"/accout/**").hasAuthority("ADMIN");
                    auth.anyRequest().authenticated();
                })
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .oauth2Login(Customizer.withDefaults())
                .build();

    }
}
