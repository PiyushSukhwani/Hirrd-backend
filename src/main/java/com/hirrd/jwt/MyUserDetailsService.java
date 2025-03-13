package com.hirrd.jwt;

import com.hirrd.dto.UserDTO;
import com.hirrd.exception.JobPortalException;
import com.hirrd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        try {
            UserDTO userDTO = userService.getUserByEmail(email);
            return new CustomUserDetails(userDTO.getId(), userDTO.getEmail(), userDTO.getPassword(), userDTO.getAccountType(), new ArrayList<>());
        } catch (JobPortalException e) {
            e.printStackTrace();
        }

        return null;
    }
}
