package net.fly.order.entity.ext;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:10
 * <p>
 * Company: 恒堃
 * <p>
 *
 * @author hengkun
 * @version 1.0.0
 **/
public class AdminDetails implements UserDetails, Serializable {

    private String username;
    private String password;

    private String adminName;
    private String userType;

    private Set<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public void setAuthorities(Set<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String getPassword() { // 最重点Ⅰ
        return this.password;
    }

    @Override
    public String getUsername() { // 最重点Ⅱ
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserType() {
        return this.userType;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminName() {
        return this.adminName;
    }
}
