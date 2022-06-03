package org.launchcode.tara.model;


import javax.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

@Entity
public class OccurrenceLog extends AbstractEntity{

    private String location;

    private String stressors;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;


    private LocalDate date;

    private String destressors;

    private String description;

    public OccurrenceLog(){}

    public OccurrenceLog(String location, String stressors, User user, String destressors, String description) {
        this.location = location;
        this.stressors = stressors;
        this.user = user;
        this.date = date.now();
        this.destressors = destressors;
        this.description = description;
    }

    public OccurrenceLog(String location, Date date, String stressors, String destressors, User user) {
        super();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStressors() {
        return stressors;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStressors(String stressors) {
        this.stressors = stressors;
    }

    public String getDestressors() {
        return destressors;
    }

    public void setDestressors(String destressors) {
        this.destressors = destressors;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
