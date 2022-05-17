package org.launchcode.tara.model;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.Instant;

@Entity
@Table(name="instance")
public class Instance extends AbstractEntity{

    @NotBlank(message="please enter a location")
    private String location;

    private String stressors;

    private String deescalation;

    private Instant createdDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "instance_log_id")
    private InstanceLog instanceLog;

    public Instance(){}

    public Instance(String location,
                    String stressors,
                    String deescalation,
                    Instant createdDate,
                    User user,
                    InstanceLog instanceLog) {
        this.location = location;
        this.stressors = stressors;
        this.deescalation = deescalation;
        this.createdDate = createdDate;
        this.user = user;
        this.instanceLog = instanceLog;
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

    public void setStressors(String stressors) {
        this.stressors = stressors;
    }

    public String getDeescalation() {
        return deescalation;
    }

    public void setDeescalation(String deescalation) {
        this.deescalation = deescalation;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Instant createdDate) {
        this.createdDate = createdDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InstanceLog getInstanceLog() {
        return instanceLog;
    }

    public void setInstanceLog(InstanceLog instanceLog) {
        this.instanceLog = instanceLog;
    }
}
