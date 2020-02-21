package com.illunex.invest.user.service;

import com.illunex.invest.user.persistence.entity.UserEntity;
import com.illunex.invest.user.persistence.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceimpl implements UserDetailsService {
    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity currentUser = repository.findByUsername(username);
        UserDetails user = new User(username, currentUser.getPassword()
                , true, true, true, true
                , AuthorityUtils.createAuthorityList(currentUser.getRole()));
        return user;
    }
}
