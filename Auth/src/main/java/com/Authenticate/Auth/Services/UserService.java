package com.Authenticate.Auth.Services;

import com.Authenticate.Auth.DTO.Request.UserSaveRequest;
import com.Authenticate.Auth.Models.Author;
import com.Authenticate.Auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    
   public Author registerUser(UserSaveRequest userSaveRequest){

  //     PasswordEncoder encoder = new BCryptPasswordEncoder();

        Author author = new Author();
        author.setName(userSaveRequest.getUser());
 //       author.setPassword(encoder.encode(userSaveRequest.getPassword()));
       author.setPassword(userSaveRequest.getPassword());
        author.setEmail(null);
        author.setPhoneNo(null);
        userRepository.save(author);

       return userRepository.findByName(userSaveRequest.getUser());
    }
}
