package com.illunex.invest.shop.persistence.entity

import java.util.ArrayList
import javax.persistence.*

@Entity
@Table(name = "plugin")
class Plugin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0

    var title: String = ""

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "pluginId")
    var pluginRole: List<PluginRole> = ArrayList()

    constructor()

    constructor(title: String, pluginRole: List<PluginRole>) {
        this.title = title
        this.pluginRole = pluginRole
    }
}
