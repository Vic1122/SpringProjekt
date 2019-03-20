package com.Vic1122.Library.services;

import com.Vic1122.Library.domain.Role;
import com.Vic1122.Library.domain.User;
import com.Vic1122.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(String userName, String password) {
        if (userName != null && password != null) {
            PasswordEncoder pe = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            User newUser = new User(userName, pe.encode(password));
            userRepository.addUser(newUser);
        }
    }

    public void addRoleToUser(String userName, String roleName) {
        if (userName != null && roleName != null) {
            Role role = new Role(roleName);
            userRepository.addRoleToUser(userName, role);
        }
    }

    public User getUser(String userName) {
        return userRepository.getUser(userName);
    }

    public User getLoggedUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            String userName = auth.getName();
            return getUser(userName);
        } else
            return null;
    }
}
