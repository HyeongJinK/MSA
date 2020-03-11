package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.company.dto.enumable.PluginState;
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
    String pluginTitle;
    LocalDateTime regDate;
    LocalDateTime expiryDate;
    @Enumerated(value = EnumType.STRING)
    PluginState state;
}
