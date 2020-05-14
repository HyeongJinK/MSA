package com.illunex.invest.user.persistence.entity;

import com.illunex.invest.api.core.user.model.UserInterface;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "user"
        , indexes = {
            @Index(name = "IDX_USERNAME", unique = true, columnList = "username"),
            @Index(name = "IDX_COMPANY_IDX", columnList = "companyIdx")
})
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter
@Builder
public class User implements UserInterface {
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
    private Set<Role> authorities = new HashSet<>();

    private String profileImg;
    private String vender;
    private Long companyIdx;
    private Boolean certification = false;
    private String dept;
    private String rank;
    private String token;
    private boolean marketing;
    @Embedded
    private Sns sns;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH, mappedBy = "user")
    private List<Signature> signatures = new ArrayList<>();



    public static User createUser(String username, String password, String name, String vender, String token, Long companyIdx) {
        return User.builder()
                .username(username)
                .profileImg("\"\"")
                .password(encodePassword(password))
                .name(name)
                .vender(vender)
                .certification(false)
                .token(token)
                .companyIdx(companyIdx)
                .authorities(Role.initRoles())
                .rank("사원")
                .sns(createSns())
                .build();
    }

    private static Sns createSns() {
        return Sns.builder().faceBook("").instagram("").linkdin("").twitter("").youtube("").build();
    }

    public static User createCompanyAdminUser(String username, String password, String name, String vender, String token, Long companyIdx) {
        return User.builder()
                .username(username)
                .profileImg("\"\"")
                .password(encodePassword(password))
                .name(name)
                .vender(vender)
                .certification(false)
                .token(token)
                .companyIdx(companyIdx)
                .authorities(Role.companyAdminRoles())
                .rank("대표")
                .sns(createSns())
                .build();
    }

//    private static UserBuilder getUserBuilder(String username, String password, String name, String vender, String token, Long companyIdx) {
//        return User.builder()
//                .username(username)
//                .profileImg("")
//                .password(encodePassword(password))
//                .name(name)
//                .vender(vender)
//                .certification(false)
//                .token(token)
//                .companyIdx(companyIdx);
//    }

    public static String encodePassword(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }

    public static boolean matchPassword(String prePassword, String inputPassword) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(inputPassword, prePassword);
    }

    @Override
    public Collection<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
