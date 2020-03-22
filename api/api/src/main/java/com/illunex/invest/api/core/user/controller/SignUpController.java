package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.request.SignUpRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "회원가입")
@RequestMapping("/signUp")
public interface SignUpController {
    @ApiOperation(value = "회원가입")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username"
                    , value = "아이디"
                    , required = true
                    , dataType = "String"
                    , paramType = "param"
                    , defaultValue = ""
            ),
            @ApiImplicitParam(name = "password"
                    , value = "비밀번호"
                    , required = true
                    , dataType = "String"
                    , paramType = "param"
                    , defaultValue = ""
            )
    })
    @PostMapping({"", "/"})
    ResponseEntity<ResponseData> signUp(@RequestBody SignUpRequest signUpRequest);

    @PostMapping({"/invite"})
    ResponseEntity<ResponseData> invite(@RequestBody SignUpRequest signUpRequest);
}
