package com.Authenticate.Auth.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping(value = "/home/signUp", method= RequestMethod.GET)
    String RegisterUser(){
        return "test";
    }
}
