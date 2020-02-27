package com.illunex.invest.user.service;

import com.illunex.invest.user.persistence.entity.Role;
import com.illunex.invest.user.persistence.entity.User;
import com.illunex.invest.user.persistence.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl extends UserService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usernameParameterCheck(username);
        User currentUser = userRepository.findByUsername(username);
        userNullCheck(currentUser);

        Set<GrantedAuthority> grantedAuthorities = createInitGrantedAuthority(currentUser);

        return new org.springframework.security.core.userdetails.User(username
                , currentUser.getPassword()
                , grantedAuthorities);
    }

    @NotNull
    private Set<GrantedAuthority> createInitGrantedAuthority(User currentUser) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (Role role: currentUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }
}
