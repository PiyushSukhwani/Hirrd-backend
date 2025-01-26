package com.hirrd.service;

import com.hirrd.dto.LoginDTO;
import com.hirrd.dto.UserDTO;
import com.hirrd.exception.JobPortalException;

public interface UserService {

    public UserDTO registerUser(UserDTO userDTO) throws JobPortalException;


    public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException;
}
