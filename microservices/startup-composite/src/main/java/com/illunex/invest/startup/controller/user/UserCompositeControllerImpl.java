package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.common.exception.ExpireUserException;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseList;
import com.illunex.invest.api.composite.startup.user.controller.UserCompositeController;
import com.illunex.invest.api.composite.startup.user.request.InviteRequest;
import com.illunex.invest.api.composite.startup.user.request.SignUpRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.exception.CertificationException;
import com.illunex.invest.api.core.user.model.JwtResponse;
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
        final UserDTO userDetails = (UserDTO) userDetailsService.loadUserByUsername(request.getUsername());
        System.out.println("=============================");
        System.out.println(userDetails.getCertification());
        if (!userDetails.getCertification()) {
            throw new CertificationException("메일 인증이 안된 계정입니다.");
        }
        final String token = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(ResponseData.builder()
                .errorCode(0)
                .data(new JwtResponse(userDetails.getName(), userDetails.getProfileImg(), token))
                .build());
    }

    @Override
    public ResponseEntity<ResponseList> list() {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData> invite(InviteRequest inviteRequest) {
        return userIntegrationService.invite(inviteRequest);
    }

    @Override
    public ResponseEntity<ResponseData> expire() {
        throw new ExpireUserException("계정이 만료되었습니다.");
    }

    @Override
    public ResponseEntity<ResponseData> certification(String token) {
        return userIntegrationService.certification(token);
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
