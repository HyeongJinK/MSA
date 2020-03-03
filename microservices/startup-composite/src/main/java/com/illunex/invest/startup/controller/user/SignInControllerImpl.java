package com.illunex.invest.startup.controller.user;
//
//import com.illunex.invest.api.core.user.controller.SingInController;
//import com.illunex.invest.api.core.user.model.JwtResponse;
//import com.illunex.invest.api.core.user.model.SignInRequest;
//import com.illunex.invest.startup.exception.user.UsernameSearchEmptyException;
//import com.illunex.invest.startup.service.user.JwtTokenUtil;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.DisabledException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//
//@RestController
//@RequiredArgsConstructor
public class SignInControllerImpl /*implements SingInController*/ {
//    private final AuthenticationManager authenticationManager;
//    private final JwtTokenUtil jwtTokenUtil;
//    private final UserDetailsService userDetailsService;
//
//    @Override
//    public ResponseEntity<JwtResponse> signIn(SignInRequest request) {
//        authenticate(request.getUsername(), request.getPassword());
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
//        final String token = jwtTokenUtil.generateToken(userDetails);
//        return ResponseEntity.ok(new JwtResponse(token));
//    }
//
////    @Override
////    public ResponseEntity<JwtResponse> signIn(String username, String password) {
////        authenticate(username, password);
////        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
////        final String token = jwtTokenUtil.generateToken(userDetails);
////        return ResponseEntity.ok(new JwtResponse(token));
////    }
//
//    private void authenticate(String username, String password) {
//        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
//        } catch (DisabledException e) {
//            throw new DisabledException("USER_DISABLED", e);
//        } catch (BadCredentialsException e) {
//            throw new BadCredentialsException("INVALID_CREDENTIALS", e);
//        }
//    }
//
//    @ExceptionHandler(DisabledException.class)
//    public ResponseEntity<HashMap> DisabledException(DisabledException e) {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("message", "USER_DISABLED");
//
//        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//    }
//
//    @ExceptionHandler(BadCredentialsException.class)
//    public ResponseEntity<HashMap> BadCredentialsException(BadCredentialsException e) {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("message", "암호가 틀렸습니다.");
//
//        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//    }
//    @ExceptionHandler(UsernameNotFoundException.class)
//    public ResponseEntity<HashMap> UsernameNotFoundException(UsernameNotFoundException e) {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("message", "아이디를 입력해주세요");
//
//        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//    }
//    @ExceptionHandler(UsernameSearchEmptyException.class)
//    public ResponseEntity<HashMap> UsernameSearchEmpty(UsernameSearchEmptyException e) {
//        HashMap<String, Object> result = new HashMap<>();
//        result.put("message", "없는 유저입니다.");
//
//        return new ResponseEntity<>(result, HttpStatus.EXPECTATION_FAILED);
//    }
}
