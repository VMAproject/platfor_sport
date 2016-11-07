package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
    public boolean addUser(User model) {
        return false;
    }

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean userExists(String username) {
        return false;
    }
}
