package com.illunex.invest.user.persistence.entity;

import com.illunex.invest.api.core.user.enumable.SignatureStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "signature")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Signature {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String imgUrl;
    @Enumerated(value = EnumType.STRING)
    SignatureStatus status;
    LocalDateTime updateDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "userId")
    User user;

    public Signature toggleStatus() {
        if (this.status == SignatureStatus.Inactive) {
            this.status = SignatureStatus.Active;
        } else {
            this.status = SignatureStatus.Inactive;
        }
        return this;
    }
}
