package com.sport.mvc.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Model {

    private static final long serialVersionUID = -8950386400041310256L;
    @NotNull(message="Имя должно быть задано")
    @Size(min = 5, message="Длина имени должна быть больше трех")
    @Column(name = "name")
    private String name;

    @NotNull(message="Фамилия должна быть задана")
    @Size(min = 5, message="Длина фамилии должна быть больше трех")
    @Column(name = "surname")
    private String surname;

    @NotNull(message="Имэйл должен быть задан")
    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",
            message = "заданный имэйл не может существовать")
    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Pattern(regexp = "^\\+?38\\(?0\\d{2}\\)?\\d{3}-?\\d{2}-?\\d{2}$",
            message ="Некоректный номер телефона" )
    @Column(name = "phone")
    private String phone;

    @Size(min = 5, message="Длина логина должна быть больше 5 символов")
    @Column(name = "username",unique = true, nullable = false)
    private String username;

    @Size(min=5, message="Длина пароля должна быть больше 5 символов")
    @Column(name = "password", nullable = false )
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "session_history_id")
    private SessionHistory sessionHistory;

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Group> groups = new HashSet<>();

    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Student> students = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        @JoinTable(name = "user_sport", joinColumns = @JoinColumn(name = "user_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<Sport> sports = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Price> prices = new HashSet<>();

    @Column(name = "isactive")
    private String isactive;

    @Column(name = "isnonexpired")
    private String isnonexpired;

    @Column(name = "isnonlocked")
    private String isnonlocked;


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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }

    public String getIsnonexpired() {
        return isnonexpired;
    }

    public void setIsnonexpired(String isnonexpired) {
        this.isnonexpired = isnonexpired;
    }

    public String getIsnonlocked() {
        return isnonlocked;
    }

    public void setIsnonlocked(String isnonlocked) {
        this.isnonlocked = isnonlocked;
    }


    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<Price> getPrices() {
        return prices;
    }

    public void setPrices(Set<Price> prices) {
        this.prices = prices;
    }

    public SessionHistory getSessionHistory() {
        return sessionHistory;
    }

    public void setSessionHistory(SessionHistory sessionHistory) {
        this.sessionHistory = sessionHistory;
    }

    public User(Role role, String username, String password, String email) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
