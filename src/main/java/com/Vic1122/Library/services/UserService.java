package com.Vic1122.Library.services;

import com.Vic1122.Library.domain.Role;
import com.Vic1122.Library.domain.User;
import com.Vic1122.Library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(String userName, String password){
        if(userName != null && password != null){
            User user = userRepository.getUser(userName);
            //System.out.println(">>>>>>>>>>>>>>>" + user.getRoles() == null);
            if(user == null) {
                User newUser = new User(userName, password);
                userRepository.addUser(newUser);
            }
        }

    }
    public void addRoleToUser(String userName, String roleName){
        if(userName != null && roleName != null){
            User user = userRepository.getUser(userName);

            if (user != null){
                Role role = new Role(roleName);
                userRepository.addRoleToUser(user, role);
            }
        }

    }
}
