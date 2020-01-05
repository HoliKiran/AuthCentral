package com.Authenticate.Auth.Controller;

import com.Authenticate.Auth.DTO.Request.UserSaveRequest;
import com.Authenticate.Auth.Models.Author;
import com.Authenticate.Auth.Services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/home/signUp", method= RequestMethod.POST)
    ResponseEntity RegisterUser(@RequestBody UserSaveRequest userSaveRequest){
   try{
       Author author =  userService.registerUser(userSaveRequest);
       return  new ResponseEntity(
               author.getName() + "registered sucessfully",
               HttpStatus.OK);

   }
   catch(Exception e){
       return  new ResponseEntity(
               "Registration failed",
               HttpStatus.BAD_REQUEST);
   }
   }

}
