//
//  keeping around just in case, but login and registration are both handled by authcontroller now
//
// package org.launchcode.tara.controller;
//
//
//import org.launchcode.tara.model.User;
//import org.launchcode.tara.service.LoginService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@CrossOrigin(origins ="http://localhost:4200")
//public class LoginController {
//
//    @Autowired
//    private LoginService service;
//
//    @PostMapping("/login")
//    public User loginUser(@RequestBody User user) throws Exception{
//        String tempEmail = user.getEmail();
//        String tempPassword = user.getPassword();
//        User userObj = null;
//        if(tempEmail != null && tempPassword != null){
//            userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPassword);
//        }
//        if (userObj == null){
//            throw new Exception("Wrong email and/or password");
//        }
//        return userObj;
//    }
//}
