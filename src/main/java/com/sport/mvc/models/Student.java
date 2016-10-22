package com.sport.mvc.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "student")
public class Student extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Student(Long id, String name, String surname, String email, Date birthday, String age, Set<Phone> phones, Set<Group> groups, Set<Sport> sports, Set<CustomerCard> cards, Set<Comment> comments, Status status) {
        super(id);
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
        this.phones = phones;
        this.groups = groups;
        this.sports = sports;
        this.cards = cards;
        this.comments = comments;
        this.status = status;
    }

    public Student(String name, String surname, String email, Date birthday, String age, Set<Phone> phones, Set<Group> groups, Set<Sport> sports, Set<CustomerCard> cards, Set<Comment> comments, Status status) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.birthday = birthday;
        this.age = age;
        this.phones = phones;
        this.groups = groups;
        this.sports = sports;
        this.cards = cards;
        this.comments = comments;
        this.status = status;
    }

    @Column(name = "email")
    private String email;

    @Column(name = "birthday")
    private Date birthday;

    @Column(name = "age")
    private String age;

    @Column(name = "phone")
    private String phone;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Phone> phones = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_group", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "group_id", nullable = false, updatable = false))
    private Set<Group> groups = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "student_sport", joinColumns = @JoinColumn(name = "student_id", nullable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "sport_id", nullable = false, updatable = false))
    private Set<Sport> sports = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<CustomerCard> cards = new HashSet<>();

    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Comment> comments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "status_id")
    private Status status;

    public Student() {
        super();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<CustomerCard> getCards() {
        return cards;
    }

    public void setCards(Set<CustomerCard> cards) {
        this.cards = cards;
    }

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }


    public Set<Sport> getSports() {
        return sports;
    }

    public void setSports(Set<Sport> sports) {
        this.sports = sports;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surName) {
        this.surname = surName;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

}
