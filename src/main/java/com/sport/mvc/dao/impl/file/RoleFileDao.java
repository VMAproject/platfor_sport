package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.RoleDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "roleFileDao")
public class RoleFileDao extends FileAbstractDao<Role> implements RoleDao {

    public RoleFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Role> getAll() {
        return null;
    }

    @Override
    public Role getById(Long id) {
        return null;
    }


    @Override
    public boolean roleExists(String roleName) {
        return false;
    }

    @Override
    public boolean addRole(Role role) {
        return false;
    }
}
