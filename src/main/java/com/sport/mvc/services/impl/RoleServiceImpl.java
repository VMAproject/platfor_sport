package com.sport.mvc.services.impl;

import com.sport.mvc.dao.RoleDao;
import com.sport.mvc.models.Role;
import com.sport.mvc.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    @Qualifier("roleDatabaseDao")
    private RoleDao roleDao;

    public RoleServiceImpl() {
    }

    @Transactional
    @Override
    public List<Role> getAllUsers() {
        return roleDao.getAll();
    }

    @Transactional
    @Override
    public Role getRoleById(Long id) {
        return roleDao.getById(id);
    }

    @Transactional
    @Override
    public boolean addRole(Role role) {
        return roleDao.addRole(role);
    }

    @Transactional
    @Override
    public boolean roleExists(String roleName) {
        return roleDao.roleExists(roleName);
    }
}
