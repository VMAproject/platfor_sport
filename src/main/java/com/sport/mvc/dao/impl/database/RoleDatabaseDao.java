package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.RoleDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "roleDatabaseDao")
public class RoleDatabaseDao extends HibernateAbstractDao<Role> implements RoleDao {

    public RoleDatabaseDao() {
    }

     @Override
    public boolean roleExists(String roleName) {
     return  getAll().size()>0 ? true : false;

    }

   @Override
    public boolean addRole(Role role) {
        getSession().save(role);
        return false;
    }
}
