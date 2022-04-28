package org.launchcode.tara.model;


import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    // TODO: create AbstractEntity for id field and extend it here

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String email;
    private String username;
    private String password;

    // TODO: add password hash and appropriate dependencies for security

    // below fields can be filled out during a post-registration questionnaire or while using the app
    // these are based off of the schema on lucidchart
    // I think these will need annotations to connect them to mySQL tables, except ndUser
    // also need to add getters and setters

    private boolean ndUser;
    private int groupId;
    private int primaryContact;
    private int instanceTracker;
    private ArrayList<Integer> stressors;
    private ArrayList<Integer> deescalators;

    public User() {
    }

    public User(int id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}