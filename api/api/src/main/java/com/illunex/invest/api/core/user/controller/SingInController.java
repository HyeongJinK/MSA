package com.illunex.invest.api.core.user.controller;

import com.illunex.invest.api.common.response.ResponseData;
import com.illunex.invest.api.core.user.model.SignInRequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "로그인")
@RequestMapping("/signIn")
public interface SingInController {
    @ApiOperation(value = "로그인")
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
    ResponseEntity<ResponseData> findUser(@RequestBody SignInRequest signInRequest);
}
