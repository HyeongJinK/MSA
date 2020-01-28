package com.illunex.invest.license.entity;

import com.illunex.invest.license.enumable.RoleType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PluginRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pluginRoleIdx;
    RoleType role;
}
