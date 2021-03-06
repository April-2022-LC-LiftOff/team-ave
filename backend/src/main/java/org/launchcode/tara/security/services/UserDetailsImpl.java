package org.launchcode.tara.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import org.launchcode.tara.model.Tag;
import org.launchcode.tara.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
public class UserDetailsImpl implements UserDetails {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String username;
    private String email;
    @JsonIgnore
    private String password;
    private Collection<? extends GrantedAuthority> authorities;

    private Collection<String> stressors;
    private Collection<String> helpers;
    private Collection<String> donts;
    public UserDetailsImpl(Integer id, String username, String email, String password,
                           Collection<? extends GrantedAuthority> authorities,
                           Collection<String> stressors, Collection<String> helpers, Collection<String> donts) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.authorities = authorities;
        this.stressors=stressors;
        this.helpers=helpers;
        this.donts=donts;
    }
    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
        List<String> stressors = user.getStressors().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        List<String> helpers = user.getHelpers().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        List<String> donts = user.getDonts().stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
        return new UserDetailsImpl(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                authorities,
                stressors,
                helpers,
                donts);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
    public Integer getId() {
        return id;
    }
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public String getUsername() {
        return username;
    }

    public Collection<String> getStressors() {
        return stressors;
    }

    public Collection<String> getHelpers() {
        return helpers;
    }

    public Collection<String> getDonts() {
        return donts;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return true;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        UserDetailsImpl user = (UserDetailsImpl) o;
        return Objects.equals(id, user.id);
    }
}