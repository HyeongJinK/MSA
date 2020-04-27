package com.illunex.invest.company.persistence.entity;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CorporateSeal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String imgUrl;
    @Enumerated(value = EnumType.STRING)
    SignatureStatus status;
    LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "companyId")
    Company company;

    public CorporateSeal toggleStatus() {
        if (this.status == SignatureStatus.Inactive) {
            this.status = SignatureStatus.Active;
        } else {
            this.status = SignatureStatus.Inactive;
        }
        return this;
    }
}
