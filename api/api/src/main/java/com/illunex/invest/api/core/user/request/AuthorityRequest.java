package com.illunex.invest.api.core.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityRequest {
    Long userId;
    List<AuthorityItem> data = new ArrayList<>();
}
