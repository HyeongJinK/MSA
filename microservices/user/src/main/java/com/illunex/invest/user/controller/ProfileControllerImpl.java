package com.illunex.invest.user.controller;

import com.illunex.invest.api.core.user.controller.ProfileController;
import com.illunex.invest.api.core.user.dto.UserDTO;
import com.illunex.invest.user.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProfileControllerImpl extends UserDefaultController implements ProfileController {
    private final ProfileService profileService;

    @Override
    public ResponseEntity<UserDTO> getUser(Long userIdx) {
        return ResponseEntity.ok(profileService.getUser(userIdx));
    }

    @Override
    public ResponseEntity<UserDTO> editUser(UserDTO userDTO) {
        return ResponseEntity.ok(profileService.editUser(userDTO));
    }
}
