package org.launchcode.tara.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class OccurrenceList extends AbstractEntity{


    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "occurrenceList")
    private List<OccurrenceLog> occurrenceLogs = new ArrayList<>();

    public OccurrenceList(){}

    public OccurrenceList(User user, List<OccurrenceLog> occurrenceLogs) {
        this.user = user;
        this.occurrenceLogs = occurrenceLogs;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OccurrenceLog> getOccurrenceLogs() {
        return occurrenceLogs;
    }

    public void setOccurrenceLogs(List<OccurrenceLog> occurrenceLogs) {
        this.occurrenceLogs = occurrenceLogs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        OccurrenceList that = (OccurrenceList) o;
        return Objects.equals(user, that.user) && Objects.equals(occurrenceLogs, that.occurrenceLogs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), user, occurrenceLogs);
    }
}
