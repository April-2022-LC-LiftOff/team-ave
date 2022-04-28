package org.launchcode.tara.controller;

import org.launchcode.tara.model.User;
import org.launchcode.tara.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegistrationController {

    @Autowired
    private RegistrationService service;

    // TODO: figure out how to show Exception messages on the front end
    // currently displays as "object Object" or something like that

    // TODO: set user in session once registered/logged in
    // TODO: add logout function and invalidate session
    // https://education.launchcode.org/java-web-development/chapters/auth/login-registration-forms.html

    @PostMapping("/registration")
    public User registerUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        if (tempEmail != null && !"".equals(tempEmail)) {
            User userObj = service.fetchUserByEmail(tempEmail);
            if (userObj != null) {
                throw new Exception("A user with this email already exists");
            }
        }
        User userObj = null;
        service.saveUser(user);
        return userObj;
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) throws Exception {
        String tempEmail = user.getEmail();
        String tempPassword = user.getPassword();
        User userObj = null;
        if (tempEmail != null && tempPassword != null) {
            userObj = service.fetchUserByEmailAndPassword(tempEmail, tempPassword);
        }
        if (userObj == null) {
            throw new Exception("Wrong email or password");
        }
        return userObj;
    }
}