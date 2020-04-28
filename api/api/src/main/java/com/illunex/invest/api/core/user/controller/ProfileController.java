package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.core.user.dto.UserDTO;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "권한설정")
@RequestMapping("/profile")
public interface ProfileController {
    @GetMapping(value = {"", "/"})
    ResponseEntity<UserDTO> getUser(@RequestParam Long userIdx);
    @PostMapping(value = {"", "/"})
    ResponseEntity<UserDTO> editUser(@RequestBody UserDTO userDTO);
}
