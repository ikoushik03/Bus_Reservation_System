package com.koushik.service;

import com.koushik.model.User;
import com.koushik.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomerUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(username);

        if(user==null)
        {
            throw   new UsernameNotFoundException("user not found exception");

        }
        return org.springframework.security.core.userdetails.User.
                withUsername(user.getEmail())
                .password(user.getPassword())
                .roles(user.getRoles().getRole())
                .build();
    }
}
