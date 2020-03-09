package com.illunex.invest.user.persistence.entity;

import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user"
        , indexes = {
            @Index(name = "IDX_USERNAME", unique=true, columnList = "username")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false)
    private String password;

    private String name;
    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    private String profileImg;

    private String vender;

    private Long companyIdx;

    private Boolean certification = false;
    private String token;
//    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<AccessControl> accessControlList = new ArrayList<>();

    public static User createCompanyAdminUser(String username, String password, String name, String vender, String token, Long companyIdx) {
        return User.builder()
                .username(username)
                .password(encodePassword(password))
                .name(name)
                .roles(Role.companyAdminRoles())
                .vender(vender)
                .certification(false)
                .token(token)
                .companyIdx(companyIdx)
                .build();
    }

    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
