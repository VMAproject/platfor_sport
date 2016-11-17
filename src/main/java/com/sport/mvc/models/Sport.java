package com.sport.mvc.models;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "sport")
public class Sport extends Model {

    ///// коментарий

    private static final long serialVersionUID = -5417868963964887203L;

    private String sport;

    private String country;

//    @ManyToMany(mappedBy = "sports")
//    private Set<User> trainers = new HashSet<>();

    @ManyToMany(mappedBy = "sports")
    private Set<Student> sports = new HashSet<>();

    public Sport() {
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

//    public Set<User> getTrainers() {
//        return trainers;
//    }
//
//    public void setTrainers(Set<User> trainers) {
//        this.trainers = trainers;
//    }

    public Set<Student> getSports() {
        return sports;
    }

    public void setSports(Set<Student> sports) {
        this.sports = sports;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Sport sport1 = (Sport) o;
//
//        if (sport != null ? !sport.equals(sport1.sport) : sport1.sport != null) return false;
//        if (country != null ? !country.equals(sport1.country) : sport1.country != null) return false;
//        if (trainers != null ? !trainers.equals(sport1.trainers) : sport1.trainers != null) return false;
//        return sports != null ? sports.equals(sport1.sports) : sport1.sports == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = sport != null ? sport.hashCode() : 0;
//        result = 31 * result + (country != null ? country.hashCode() : 0);
//        result = 31 * result + (trainers != null ? trainers.hashCode() : 0);
//        result = 31 * result + (sports != null ? sports.hashCode() : 0);
//        return result;
//    }
}
