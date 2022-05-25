package org.launchcode.tara.model;


import javax.persistence.*;
import java.time.Instant;
import java.util.Date;

@Entity
public class OccurrenceLog extends AbstractEntity{

    private String location;

    private String stressors;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    private OccurrenceList occurrenceList;

    private Instant date;

    private String destressors;

    public OccurrenceLog(){}

    public OccurrenceLog(String location, String stressors, User user, String destressors, OccurrenceList occurrenceList) {
        this.location = location;
        this.stressors = stressors;
        this.user = user;
        this.date = Instant.now();
        this.destressors = destressors;
        this.occurrenceList = occurrenceList;
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

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }
}
