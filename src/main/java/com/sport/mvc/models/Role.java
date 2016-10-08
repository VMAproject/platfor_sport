package com.sport.mvc.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role extends Model {

    private static final long serialVersionUID = -5380958355394845918L;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "title", length = 25, insertable = false, updatable = false)
    private RoleList roleUser;

    @Column(name = "description", length = 255)
    private String description;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
        super();
    }

    public Role(Long id) {
        super(id);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RoleList getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleList roleUser) {
        this.roleUser = roleUser;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
