package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "userFileDao")
public class UserFileDao extends FileAbstractDao<User> implements UserDao {

    public UserFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User getByUsername(String username) {
        return null;
    }
}
