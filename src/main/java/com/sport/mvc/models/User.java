package com.sport.mvc.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "user")
public class User extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "phone")
    private String phone;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false))
    private Set<Group> groups2 = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_sport", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<Sport> sports = new HashSet<>();

    public User() {
        super();
    }

    public User(Long id) {
        super(id);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public Set<Group> getGroups2() {
        return groups2;
    }

    public void setGroups2(Set<Group> groups2) {
        this.groups2 = groups2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
