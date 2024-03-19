package com.dsecurity.security.userPrincipal;

import com.dsecurity.entity.Users;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.BitSet;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserPrincipal implements UserDetails {
    private Long id;
    private String username;
    @JsonIgnore
    private String password;
    private String fullName;
    private String email;
    private String avatar;
    private String phone;
    private boolean status;
    private Collection<? extends GrantedAuthority> roles;


    public static UserPrincipal build(Users user) {

        List<GrantedAuthority> grantedAuthorities = user.getRoles().stream().map(
                role -> new SimpleGrantedAuthority(role.getRoleName().name())
        ).collect(Collectors.toList());

        return UserPrincipal.builder()
                .id(user.getId())
                .username(user.getUsername())
                .password(user.getPassword())
                .fullName(user.getFullName())
                .avatar(user.getAvatar())
                .phone(user.getPhone())
                .fullName(user.getFullName())
                .email(user.getEmail())
                .roles(grantedAuthorities)
                .build();
    }


    /**
     *
     * @return collection role (quyền)
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Tài khoản có bị không hết hạn không?
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Tài khoản có không bị block không?
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Mã xác nhận có không bị hết hạn hay không?
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * kich hoạt hay chưa?
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
