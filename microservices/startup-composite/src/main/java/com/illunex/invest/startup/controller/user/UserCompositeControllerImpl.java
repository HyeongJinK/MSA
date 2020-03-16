package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.common.exception.FileUploadException;
import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.common.response.ResponseListData;
import com.illunex.invest.api.composite.startup.user.controller.UserCompositeController;
import com.illunex.invest.api.composite.startup.user.model.SignUpRequest;
import com.illunex.invest.api.core.user.exception.UsernameSearchEmptyException;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.MyPageChangePasswordRequest;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.startup.controller.StartupDefaultController;
import com.illunex.invest.startup.service.user.JwtTokenUtil;
import com.illunex.invest.startup.service.user.UserCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
public class UserCompositeControllerImpl extends StartupDefaultController implements UserCompositeController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final UserCompositeIntegration userCompositeIntegration;


    @Override
    public ResponseEntity<ResponseData> signUp(SignUpRequest signUpRequest) {
        return userCompositeIntegration.signUp(signUpRequest.getUsername()
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

    @Override
    public ResponseEntity<ResponseData> changePassword(MyPageChangePasswordRequest request) {
        return userCompositeIntegration.changePassword(request.getPrePassword(), request.getPassword());
    }

    @Override
    public ResponseEntity<ResponseListData> signature() {
        return userCompositeIntegration.signatureList();
    }

    @Override
    public ResponseEntity<ResponseData> signature(MultipartFile file) {
        return userCompositeIntegration.signature(file);
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

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<ResponseData> DisabledException(DisabledException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<ResponseData> BadCredentialsException(BadCredentialsException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ResponseData> UsernameNotFoundException(UsernameNotFoundException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<ResponseData> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        return exceptionProcess(e.getMessage());
    }

    @ExceptionHandler(FileUploadException.class)
    public ResponseEntity<ResponseData> FileUpload(FileUploadException e) {
        return exceptionProcess(e.getMessage());
    }
}