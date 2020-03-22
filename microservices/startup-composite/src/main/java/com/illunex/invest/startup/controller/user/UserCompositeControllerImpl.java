package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.composite.startup.user.controller.UserCompositeController;
import com.illunex.invest.api.composite.startup.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.composite.startup.mypage.request.MyPageChangePasswordRequest;
import com.illunex.invest.api.core.user.request.SignInRequest;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.user.JwtTokenUtil;
import com.illunex.invest.startup.service.user.UserIntegrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserCompositeControllerImpl extends StartupDefaultController implements UserCompositeController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final UserIntegrationService userIntegrationService;

    @Override
    public ResponseEntity<ResponseData> signUp(SignUpRequest signUpRequest) {
        return userIntegrationService.signUp(signUpRequest.getUsername()
                , signUpRequest.getPassword()
                , signUpRequest.getName()
                , signUpRequest.getBusinessNumber()
                , "illunex"
        );
    }

    @Override
    public ResponseEntity<ResponseData> signIn(SignInRequest request) {
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(new JwtResponse(token))
                .build());
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("비밀번호가 틀렸습니다.", e);
        }
    }
}