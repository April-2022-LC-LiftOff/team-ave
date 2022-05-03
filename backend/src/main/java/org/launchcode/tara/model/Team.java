package org.launchcode.tara.model;


import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team extends AbstractEntity{

    private String name;

    @OneToMany(mappedBy="team")
    private final List<User> users = new ArrayList<>();

    public Team(){}

    public Team(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }
}
