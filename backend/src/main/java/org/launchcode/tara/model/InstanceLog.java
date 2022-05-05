package org.launchcode.tara.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.Date;

@Entity
public class InstanceLog extends AbstractEntity{

    private String location;

    private String stressor;

    @ManyToOne
    private User user;

    private Date date;
    private String deescalation;

    public InstanceLog(){}

    public InstanceLog(String location, String stressor, User user,
                       Date date, String deescalation){
        this.location=location;
        this.stressor=stressor;
        this.user=user;
        this.date=date;
        this.deescalation=deescalation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStressor() {
        return stressor;
    }

    public void setStressor(String stressor) {
        this.stressor = stressor;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @DateTimeFormat(pattern="MM/dd/yyyy")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeescalation() {
        return deescalation;
    }

    public void setDeescalation(String deescalation) {
        this.deescalation = deescalation;
    }


}
