package com.illunex.invest.startup.service.user;


import com.illunex.invest.api.core.user.dto.RoleDTO;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.exception.user.UsernameSearchEmptyException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class UserDetailsServiceImpl implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserCompositeIntegration userCompositeIntegration;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        logger.debug("=================================1");
        logger.debug(username);
        logger.debug("=================================2");
        usernameParameterCheck(username);
        UserDTO currentUser = userCompositeIntegration.signIn(username);
        logger.debug("=================================");
        logger.debug(currentUser.toString());
        logger.debug("=================================");
        userNullCheck(currentUser);

        Set<GrantedAuthority> grantedAuthorities = createInitGrantedAuthority(currentUser);

        return new org.springframework.security.core.userdetails.User(username
                , currentUser.getPassword()
                , grantedAuthorities);
    }

    protected void userNullCheck(UserDTO currentUser) {
        if (currentUser == null) {
            throw new UsernameSearchEmptyException("유저가 없습니다.");
        }
    }

    protected void usernameParameterCheck(String username) {
        if (username == null || username.equals("")) {
            throw new UsernameNotFoundException("Username 파라미터가 없습니다.");
        }
    }

    @NotNull
    private Set<GrantedAuthority> createInitGrantedAuthority(UserDTO currentUser) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleDTO role: currentUser.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
        }
        return grantedAuthorities;
    }
}
