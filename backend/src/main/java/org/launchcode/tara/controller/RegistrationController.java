//
// keeping around just in case, but login and registration are both handled by authcontroller now
//
// package org.launchcode.tara.controller;
//
//import org.launchcode.tara.model.User;
//import org.launchcode.tara.service.RegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@CrossOrigin(origins = "http://localhost:4200")
//public class RegistrationController {
//
//    @Autowired
//    private RegistrationService service;
//
//    @PostMapping("/registration")
//    public User registerUser(@RequestBody User user) throws Exception {
//        String tempEmail = user.getEmail();
//        if (tempEmail != null && !"".equals(tempEmail)) {
//            User userObj = service.fetchUserByEmail(tempEmail);
//            if (userObj != null) {
//                System.out.println("error");
//                throw new Exception("A user with this email already exists");
//            }
//        }
//        User userObj = null;
//        service.saveUser(user);
//        return userObj;
//    }
//
//}