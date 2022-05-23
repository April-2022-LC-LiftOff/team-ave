package org.launchcode.tara.model;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username"),
                @UniqueConstraint(columnNames = "email")
        })

public class User extends AbstractEntity {

    @NotBlank
    @Size(max = 20)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;

    @NotBlank
    @Size(max = 120)
    private String password;

    @ManyToOne
    private Team team;

    @OneToMany(mappedBy = "user")
    private List<OccurrenceLog> occurrenceLogs = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "occurrence_list_id")
    private OccurrenceList occurrenceList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(	name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public OccurrenceList getOccurrenceList() {
        return occurrenceList;
    }

    public void setOccurrenceList(OccurrenceList occurrenceList) {
        this.occurrenceList = occurrenceList;
    }

    public User() {
    }

    public User( String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public List<OccurrenceLog> getOccurrenceLogs() {
        return occurrenceLogs;
    }

    public void setOccurrenceLogs(List<OccurrenceLog> occurrenceLogs) {
        this.occurrenceLogs = occurrenceLogs;
    }
}