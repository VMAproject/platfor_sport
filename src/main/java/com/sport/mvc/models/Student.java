package com.sport.mvc.models;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.Null;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student extends Model {

    private static final long serialVersionUID = -8950386400041310256L;

    @Column(name = "name")
    //@Size(min=3, max=30)
    private String name;

    //@Size(min=3, max=30)
    @Column(name = "surname")
    private String surname;

    @Column(name = "record_day")
    private String recordDay;

    @Column(name = "comments")
    private String comments;

    @Column(name = "post")
    private String post;



    @Column(name = "email")
    @Email
    private String email;




    @Column(name = "birthday")
    @DateTimeFormat(pattern="dd/MM/yyyy")
    @Past
    private Date birthday;

    @Pattern(regexp = "[0-9]{2,2}.[0-9]{2,2}.[1-2]{1,1}[0-9]{3,3}", message = "{Pattern.student.strBirthday}")
    @Column(name = "string_birthday")
    private String strBirthday;

    @Column(name = "age")
    private String age;

   // @Pattern(regexp = "[0-9]{10,10}+", message="{Pattern.student.phone}")
    @Column(name = "phone")
    private String phone;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Student() {
        super();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getStrBirthday() {
        return strBirthday;
    }

    public void setStrBirthday(String strBirthday) {
        this.strBirthday = strBirthday;
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

    public Set<Group> getGroups() {
        return groups;
    }

    public void setGroups(Set<Group> groups) {
        this.groups = groups;
    }

    public Set<CustomerCard> getCards() {
        return cards;
    }

    public void setCards(Set<CustomerCard> cards) {
        this.cards = cards;
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

    public String getPhone() {
        return phone;
    }


    public String getRecordDay() {
        return recordDay;
    }

    public void setRecordDay(String recordDay) {
        this.recordDay = recordDay;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


}