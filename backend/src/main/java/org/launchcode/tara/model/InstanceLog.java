package org.launchcode.tara.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class InstanceLog extends AbstractEntity{

    private Instant createdDate;

    @ManyToOne(fetch= FetchType.LAZY)
    private User user;

    @NotBlank(message="please name your log")
    private String logName;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Instance> instances = new ArrayList<>();

    public InstanceLog(){}

    public InstanceLog(User user,
                       String logName,
                       Instant createdDate,
                       Instance instances){
        this.user=user;
        this.logName=logName;
        this.createdDate=createdDate;
        this.instances = (List<Instance>) instances;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Instant getCreatedDate() {return createdDate;}
    public void setCreatedDate(Instant createdDate) {this.createdDate = createdDate;}
    public String getLogName() {return logName;}
    public void setLogName(String logName) {this.logName = logName;}

    public List<Instance> getInstances() {return instances;}

    public void setInstances(List<Instance> instances) {this.instances = instances;}
}
