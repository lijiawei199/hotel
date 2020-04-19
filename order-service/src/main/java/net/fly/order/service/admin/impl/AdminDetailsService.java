package net.fly.order.service.admin.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import net.fly.order.dao.AdminDao;
import net.fly.order.entity.Admin;
import net.fly.order.entity.ext.AdminDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * 标题、简要说明. <br>
 * 类详细说明.
 * <p>
 * Copyright: Copyright (c) 2019-09-02 16:19
 * <p>
 * Company: 恒堃
 * <p>
 *
 * @author hengkun
 * @version 1.0.0
 **/
@Component
@Slf4j
public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //构建用户信息的逻辑(取数据库/LDAP等用户信息)
        AdminDetails userInfo = new AdminDetails();
        Admin admin = adminDao.getOne(new LambdaQueryWrapper<Admin>()
                .eq(Admin::getStaffid, username)
        );
        if (null == admin) {
            return userInfo;
        }
        userInfo.setUsername(username);
        userInfo.setPassword(admin.getPassword());
        userInfo.setAdminName(admin.getAdminName());
        userInfo.setUserType(admin.getAdminRoute());

        Set<GrantedAuthority> authoritiesSet = new HashSet<GrantedAuthority>();
        GrantedAuthority authority = new SimpleGrantedAuthority(admin.getAdminRoute());
        authoritiesSet.add(authority);
        userInfo.setAuthorities(authoritiesSet);

        return userInfo;
    }

    public static void main(String[] args) {


        String pwd = new BCryptPasswordEncoder().encode("cash2019b");
        System.out.println(pwd);
    }
}
