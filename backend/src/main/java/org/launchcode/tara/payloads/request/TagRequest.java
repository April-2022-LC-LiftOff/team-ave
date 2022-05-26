package org.launchcode.tara.payloads.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

public class TagRequest {
    @NotNull
    private int userId;

    @NotBlank
    private String username;


    private ArrayList<String> stressors;


    private ArrayList<String> helpers;


    private ArrayList<String> donts;

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

    public ArrayList<String> getHelpers() {
        return helpers;
    }

    public void setHelpers(ArrayList<String> helpers) {
        this.helpers = helpers;
    }

    public ArrayList<String> getDonts() {
        return donts;
    }

    public void setDonts(ArrayList<String> donts) {
        this.donts = donts;
    }
}
