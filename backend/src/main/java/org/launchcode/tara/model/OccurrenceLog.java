package org.launchcode.tara.model;


import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class OccurrenceLog extends AbstractEntity{

    private String location;

    private String stressors;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Date date;
    private String destressors;

    public OccurrenceLog(){}

    public OccurrenceLog(String location, String stressors, User user,
                         Date date, String destressors){
        this.location=location;
        this.stressors=stressors;
        this.user=user;
        this.date=date;
        this.destressors=destressors;
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

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() { return date; }


}
