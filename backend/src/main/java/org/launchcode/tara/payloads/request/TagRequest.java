package org.launchcode.tara.payloads.request;

import java.util.ArrayList;

public class TagRequest {
    private int userId;

    private String username;

    private ArrayList<String> stressors;

    private ArrayList<String> destressors;

    private ArrayList<String> donots;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getStressors() {
        return stressors;
    }

    public void setStressors(ArrayList<String> stressors) {
        this.stressors = stressors;
    }

    public ArrayList<String> getDestressors() {
        return destressors;
    }

    public void setDestressors(ArrayList<String> destressors) {
        this.destressors = destressors;
    }

    public ArrayList<String> getDonots() {
        return donots;
    }

    public void setDonots(ArrayList<String> donots) {
        this.donots = donots;
    }
}
