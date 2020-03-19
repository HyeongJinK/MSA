package com.illunex.invest.shop.persistence.entity

import javax.persistence.*

@Entity
@Table(name = "plugin_install")
class PluginInstall {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var companyId: Long = 0
    var active: Boolean = true
    @ManyToOne(cascade = [CascadeType.DETACH], fetch = FetchType.LAZY)
    @JoinColumn(name = "pluginId")
    var plugin: Plugin? = null

    constructor()
    constructor(companyId: Long, active: Boolean, plugin: Plugin?) {
        this.companyId = companyId
        this.active = active
        this.plugin = plugin
    }
    
    fun toggle() {
        this.active = !this.active
    }
}