package com.hirrd.jwt;

import com.hirrd.dto.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomUserDetails implements UserDetails {

    private Long id;
    private String username;
    private String name;
    private String password;
    private AccountType accountType;
    private Long profileId;
    private Collection<? extends GrantedAuthority> authorities;

}












