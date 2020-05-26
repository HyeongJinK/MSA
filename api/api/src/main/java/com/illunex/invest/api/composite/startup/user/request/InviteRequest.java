package com.illunex.invest.api.composite.startup.user.request;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class InviteRequest {
    List<SignUpRequest> list = new ArrayList<>();
}
