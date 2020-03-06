package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.composite.startup.user.controller.UserCompositeController;
import com.illunex.invest.api.composite.startup.user.model.SignUpRequest;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.JwtResponse;
import com.illunex.invest.api.core.user.model.SignInRequest;
import com.illunex.invest.startup.exception.user.UsernameSearchEmptyException;
import com.illunex.invest.startup.service.user.JwtTokenUtil;
import com.illunex.invest.startup.service.user.UserCompositeIntegration;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RestController
@RequiredArgsConstructor
public class UserCompositeControllerImpl implements UserCompositeController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final UserCompositeIntegration userCompositeIntegration;


    @Override
    public ResponseEntity<HashMap> signUp(SignUpRequest signUpRequest) {
        return userCompositeIntegration.signUp(signUpRequest.getUsername()
                , signUpRequest.getPassword()
                , signUpRequest.getName()
                , signUpRequest.getBusinessNumber()
        );
    }

    @Override
    public ResponseEntity<JwtResponse> signIn(SignInRequest request, HttpServletRequest httpServletRequest) {
        authenticate(request.getUsername(), request.getPassword());
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new DisabledException("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
        }
    }

    @ExceptionHandler(DisabledException.class)
    public ResponseEntity<HashMap> DisabledException(DisabledException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "USER_DISABLED");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<HashMap> BadCredentialsException(BadCredentialsException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "INVALID_CREDENTIALS");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<HashMap> UsernameNotFoundException(UsernameNotFoundException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "UsernameNotFoundException");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }

    @ExceptionHandler(UsernameSearchEmptyException.class)
    public ResponseEntity<HashMap> UsernameSearchEmpty(UsernameSearchEmptyException e) {
        HashMap<String, Object> result = new HashMap<>();
        result.put("message", "UsernameSearchEmpty");

        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
    }
}