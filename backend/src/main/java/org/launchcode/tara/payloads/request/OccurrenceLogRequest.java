package org.launchcode.tara.payloads.request;

import java.util.Date;

public class OccurrenceLogRequest {

    private String location;
    private Date date;
    private String stressors;
    private String destressors;
    private int userId;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStressors() {
        return stressors;
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

    public int getUserId() {
        return userId ;
    }

    public void setUser(int userId) {
        this.userId = userId;
    }
}
