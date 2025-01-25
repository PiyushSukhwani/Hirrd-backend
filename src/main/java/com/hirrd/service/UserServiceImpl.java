package com.hirrd.service;

import com.hirrd.dto.UserDTO;
import com.hirrd.model.User;
import com.hirrd.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO registerUser(UserDTO userDTO) {
        User user = userDTO.toEntity();
        user = userRepository.save(user);
        return user.toDTO();
    }
}
