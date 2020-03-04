package com.illunex.invest.shop.persistence.entity

import com.illunex.invest.shop.persistence.entity.enumable.PluginState
import org.hibernate.annotations.GeneratorType
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

    @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.DETACH], mappedBy = "plugin")
    private var pluginInstallList: List<PluginInstall> = ArrayList()

    private var state: PluginState = PluginState.OPEN

    constructor()

    constructor(title: String, state: PluginState) {
        this.title = title
        this.state = state
    }
}