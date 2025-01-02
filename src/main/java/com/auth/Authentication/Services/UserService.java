package com.auth.Authentication.Services;

import com.auth.Authentication.Repository.UserRepository;
import com.auth.Authentication.entity.User;
import com.auth.Authentication.dto.RegisterRequest;
import com.auth.Authentication.dto.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    User registerUser(RegisterRequest request);

    User authenticateUser(LoginRequest request); // Add this method
    @Autowired
    UserRepository userRepository = null;

    public default User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}