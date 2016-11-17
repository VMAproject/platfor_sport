package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group2")
public class Group extends Model {

    private static final long serialVersionUID = 5110150966894003873L;


    @Column(name = "is_main")
    private boolean isMain;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

    public Group(Long id) {
        super(id);
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL)
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryGroup categoryGroup;



    @OneToOne(mappedBy = "groups", cascade = CascadeType.ALL, orphanRemoval = true)
    private Price prices ;

    public Group() {
        super();
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CategoryGroup getCategoryGroup() {
        return categoryGroup;
    }

    public void setCategoryGroup(CategoryGroup categoryGroup) {
        this.categoryGroup = categoryGroup;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public boolean isMain() {
        return isMain;
    }

    public void setMain(boolean main) {
        isMain = main;
    }



    public Price getPrices() {
        return prices;
    }

    public void setPrices(Price prices) {
        this.prices = prices;
    }
}
