package com.illunex.invest.api.core.user.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PurchaseRoleRequest {
    Long userId;
    List<String> roles = new ArrayList();
}
