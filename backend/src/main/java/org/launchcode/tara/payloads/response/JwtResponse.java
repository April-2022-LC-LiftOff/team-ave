package org.launchcode.tara.payloads.response;

import org.launchcode.tara.model.Tag;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Integer id;
    private String username;
    private String email;
    private List<String> roles;

    private List<String> stressors;

    private List<String> helpers;

    private List<String> donts;

    public JwtResponse(String accessToken, Integer id, String username, String email,
                       List<String> roles, List<String> stressors, List<String> helpers, List<String> donts) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.stressors=stressors;
        this.helpers=helpers;
        this.donts=donts;
    }

    public String getAccessToken() {
        return token;
    }

    public void setAccessToken(String accessToken) {
        this.token = accessToken;
    }

    public String getTokenType() {
        return type;
    }

    public void setTokenType(String tokenType) {
        this.type = tokenType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }

    public List<String> getStressors() {
        return stressors;
    }

    public List<String> getHelpers() {
        return helpers;
    }


    public List<String> getDonts() {
        return donts;
    }

}
