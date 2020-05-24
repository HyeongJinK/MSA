package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.company.dto.enumable.PluginState;
import com.illunex.invest.api.core.company.request.PluginRequest;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plugin")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Plugin {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long productId;
    //Long pluginId;
    LocalDateTime regDate;
    LocalDateTime expiryDate;
    @Enumerated(value = EnumType.STRING)
    PluginState state;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "companyId")
    Company company;

    public static Plugin createPlugin(PluginRequest request, Long id) {
        return Plugin.builder()
                .productId(id)
                .company(new Company(request.getCompanyId()))
                .state(PluginState.OPEN)
                .expiryDate(request.getExpiryDate())
                .regDate(LocalDateTime.now())
                .build();
    }

    public void toggle() {
        if (state.equals(PluginState.OPEN)) {
            state = PluginState.CLOSE;
        } else {
            state = PluginState.OPEN;
        }
    }
}
