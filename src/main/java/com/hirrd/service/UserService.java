package com.hirrd.service;

import com.hirrd.dto.LoginDTO;
import com.hirrd.dto.ResponseDTO;
import com.hirrd.dto.UserDTO;
import com.hirrd.exception.JobPortalException;

public interface UserService {

    public UserDTO registerUser(UserDTO userDTO) throws JobPortalException;


    public UserDTO loginUser(LoginDTO loginDTO) throws JobPortalException;

    public boolean sendOtp(String email) throws Exception;

    public boolean verifyOtp(String email, String otp) throws JobPortalException;

    public ResponseDTO changePassword(LoginDTO loginDTO) throws JobPortalException;
}
