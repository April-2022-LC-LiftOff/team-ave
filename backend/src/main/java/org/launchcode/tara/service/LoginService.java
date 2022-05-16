//package org.launchcode.tara.service;
//
//
//import org.launchcode.tara.model.User;
//import org.launchcode.tara.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import javax.servlet.http.HttpSession;
//import java.util.Optional;
//
//@Service
//public class LoginService {
//
//    @Autowired
//    private UserRepository logRepo;
//
//    public User fetchUserByEmail(String email) {
//        return logRepo.findByEmail(email);
//    }
//
//    public User fetchUserByEmailAndPassword(String email, String password) {
//        return logRepo.findByEmailAndPassword(email, password);
//    }
//
//    // session-handler
//
//    private static final String userSessionKey = "user";
//
//    public User getUserFromSession(HttpSession session) {
//        Integer userId = (Integer) session.getAttribute(userSessionKey);
//        if (userId == null) {
//            return null;
//        }
//
//        Optional<User> user = logRepo.findById(userId);
//
//        if (user.isEmpty()) {
//            return null;
//        }
//
//        return user.get();
//    }
//
//    private static void setUserInSession(HttpSession session, User user) {
//        session.setAttribute(userSessionKey, user.getId());
//    }
//}
