package com.illunex.invest.startup.controller.user;

import com.illunex.invest.api.core.user.controller.PasswordChangeController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.api.core.user.model.ChangePasswordRequest;
import com.illunex.invest.startup.service.user.ChangePasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PasswordChangeControllerImpl implements PasswordChangeController {
    private final ChangePasswordService changePasswordService;
    @Override
    public ResponseEntity<UserDTO> changePassword(ChangePasswordRequest request) {
        return new ResponseEntity<>(changePasswordService.changePassword(request.getUsername()
                    , request.getPrePassword()
                    , request.getPassword())
                , HttpStatus.OK);
    }
}
