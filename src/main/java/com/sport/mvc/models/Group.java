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

    @Deprecated
    @Column(name = "nameTraine")
    private String nameTraine;

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

    public String getNameTraine() {
        return nameTraine;
    }

    public void setNameTraine(String nameTraine) {
        this.nameTraine = nameTraine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Group group = (Group) o;

        if (name != null ? !name.equals(group.name) : group.name != null) return false;
        if (nameTraine != null ? !nameTraine.equals(group.nameTraine) : group.nameTraine != null) return false;
        if (discription != null ? !discription.equals(group.discription) : group.discription != null) return false;
        if (user != null ? !user.equals(group.user) : group.user != null) return false;
        if (students != null ? !students.equals(group.students) : group.students != null) return false;
        return categoryGroup != null ? categoryGroup.equals(group.categoryGroup) : group.categoryGroup == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (nameTraine != null ? nameTraine.hashCode() : 0);
        result = 31 * result + (discription != null ? discription.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (students != null ? students.hashCode() : 0);
        result = 31 * result + (categoryGroup != null ? categoryGroup.hashCode() : 0);
        return result;
    }
}
