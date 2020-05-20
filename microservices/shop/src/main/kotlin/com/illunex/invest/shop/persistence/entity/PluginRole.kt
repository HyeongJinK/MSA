package com.illunex.invest.shop.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "plugin_role")
class PluginRole {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var roleTitle: String = ""
    var menuTitle: String = ""

    constructor()

    constructor(roleTitle: String) {
        this.roleTitle = roleTitle
    }
}
