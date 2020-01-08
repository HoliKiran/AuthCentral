package com.Authenticate.Auth.Services;

import com.Authenticate.Auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyuserDetailsService  implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String userName) {
        return  new User(userRepository.findByName(userName).getName(),
                userRepository.findByName(userName).getPassword(),new  ArrayList());
    }


}
