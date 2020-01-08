package com.Authenticate.Auth.Controller;

import com.Authenticate.Auth.DTO.Request.AuthRequest;
import com.Authenticate.Auth.DTO.Request.UserSaveRequest;
import com.Authenticate.Auth.Models.Author;
import com.Authenticate.Auth.Services.MyuserDetailsService;
import com.Authenticate.Auth.Services.UserService;
import com.Authenticate.Auth.Utli.JwtUtill;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyuserDetailsService myuserDetailsService;

    @Autowired
    JwtUtill jwtUtill;

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

    @RequestMapping(value = "/home/Authenticate", method= RequestMethod.POST)
    ResponseEntity createJwtToken(@RequestBody AuthRequest authRequest){
        try{
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(),authRequest.getPassword())
        );
        }
        catch(Exception e){
            return new ResponseEntity("couldnot create the token",HttpStatus.BAD_REQUEST);
        }

        final UserDetails userDetails = myuserDetailsService.loadUserByUsername(authRequest.getUserName());
        final String jwt = jwtUtill.generateToken(userDetails);

        return  new ResponseEntity(jwt,HttpStatus.OK);


    }

}
