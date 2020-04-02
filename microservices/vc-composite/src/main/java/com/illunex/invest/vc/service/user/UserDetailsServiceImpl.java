package com.illunex.invest.vc.service.user;


import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    //Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);
    private final UserIntegrationService userIntegrationService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        usernameParameterCheck(username);
        UserDTO currentUser = userIntegrationService.signIn(username);
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
