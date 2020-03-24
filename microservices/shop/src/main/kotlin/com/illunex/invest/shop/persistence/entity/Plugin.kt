package com.illunex.invest.shop.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "plugin")
class Plugin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id : Long = 0

    private var title: String = ""

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
    @JoinColumn(name = "pluginId")
    private var pluginRole: List<PluginRole> = ArrayList()

    constructor()

    constructor(title: String, pluginRole: List<PluginRole>) {
        this.title = title
        this.pluginRole = pluginRole
    }

    fun getId(): Long {
        return id;
    }
}