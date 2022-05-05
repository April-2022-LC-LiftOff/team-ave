package org.launchcode.tara.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends AbstractEntity{

    private String email;
    private String username;
    private String password;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "user")
    private final List<InstanceLog> instancelog =new ArrayList<>();

    public User() {
    }

    public User( String email, String username, String password) {

        this.email = email;
        this.username = username;
        this.password = password;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<InstanceLog> getInstancelog() {
        return instancelog;
    }
}