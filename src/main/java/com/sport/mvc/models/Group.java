package com.sport.mvc.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "group2")
public class Group extends Model {

    private static final long serialVersionUID = 5110150966894003873L;

    @Column(name = "name")
    private String name;

    @Column(name = "discription")
    private String discription;

    @ManyToMany(mappedBy = "groups")
    private Set<User> treiners = new HashSet<>();

    @ManyToMany(mappedBy = "groups")
    private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "category_id")
    private CategoryGroup categoryGroups;

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

    public Set<User> getTreiners() {
        return treiners;
    }

    public void setTreiners(Set<User> treiners) {
        this.treiners = treiners;
    }

    public CategoryGroup getCategoryGroups() {
        return categoryGroups;
    }

    public void setCategoryGroups(CategoryGroup categoryGroups) {
        this.categoryGroups = categoryGroups;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}