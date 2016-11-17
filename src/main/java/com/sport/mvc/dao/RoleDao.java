package com.sport.mvc.dao;

import com.sport.mvc.models.Role;

public interface RoleDao extends ItemDao<Role> {

    boolean roleExists(String roleName);

    boolean addRole(Role role);

}
