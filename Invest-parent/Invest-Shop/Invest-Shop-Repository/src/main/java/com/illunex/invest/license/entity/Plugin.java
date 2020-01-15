package com.illunex.invest.license.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Plugin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long pluginIdx;
    String title;

    @OneToMany
    List<PluginRole> pluginRoles;
}
