package com.illunex.invest.startup.service.user;


import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.startup.exception.user.UsernameSearchEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    //Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserCompositeIntegration userCompositeIntegration;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usernameParameterCheck(username);
        UserDTO currentUser = userCompositeIntegration.signIn(username);
        userNullCheck(currentUser);

        return currentUser;
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
}
