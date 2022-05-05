package org.launchcode.tara.service;


import org.launchcode.tara.model.User;
import org.launchcode.tara.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private UserRepository logRepo;

    public User fetchUserByEmail(String email) { return logRepo.findByEmail(email);}

    public User fetchUserByEmailAndPassword(String email, String password) {
        return logRepo.findByEmailAndPassword(email, password);
    }
}
