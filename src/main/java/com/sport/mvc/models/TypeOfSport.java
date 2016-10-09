package com.sport.mvc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sports")
public class TypeOfSport extends Model {

    private static final long serialVersionUID = -5417868963964887203L;

    private String sport;

    private String country;

    @ManyToMany(mappedBy = "sports")
    private Set<User> users = new HashSet<>();

    public TypeOfSport() {
        super();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
