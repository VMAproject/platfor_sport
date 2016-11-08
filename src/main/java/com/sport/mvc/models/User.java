package com.sport.mvc.models;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

//    @Size(min = 3,max = 30)
//    @Pattern(regexp = "^[А-Яа-яЁё\\s]+$", message = "patern.name.registration")
    @Column(name = "name")
    private String name;

//    @Size(min = 3,max = 30)
//    @Pattern(regexp = "^[А-Яа-яЁё\\s]+$", message = "patern.name.registration")
    @Column(name = "surname")
    private String surname;

//    @Pattern(regexp = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$",message = "patern.email.registration")
    @Column(name = "email")
    private String email;

//    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Column(name = "birthday")
    private Date birthday;

//    @Pattern(regexp = "^\\+?38\\(?0\\d{2}\\)?\\d{3}-?\\d{2}-?\\d{2}$",message = "patern.phone.registration")
    @Column(name = "phone")
    private String phone;



//    @Pattern(regexp = "^[A-Za-z0-9]{3,}$")
    @Column(name = "username")
    private String username;

//    @Pattern(regexp = "^[A-Za-z0-9]{3,}$")
    @Column(name = "password")
    private String password;

    @Column(name = "city")
    private String city;

    @Column(name = "country")
    private String country;

    @Column(name = "district")
    private String district;

    @Column(name = "isactive")
    private String isactive;

    @Column(name = "isnonexpired")
    private String isnonexpired;

    @Column(name = "isnonlocked")
    private String isnonlocked;

//    @ManyToOne(fetch = FetchType.LAZY, optional = true)
//    @JoinColumn(name = "session_history_id")
//    private SessionHistory sessionHistory;
//
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
//
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "price_id")
    private Price price;

    public Price getPrice() {
        return price;
    }

    public void setPrice(Price price) {
        this.price = price;
    }


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

    public User(Role role, String username, String password, String email) {
        this.role = role;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}
