package com.sport.mvc.services.impl;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import com.sport.mvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.acls.model.NotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "userService")
public class UserServiceImpl implements UserService{

    @Qualifier("userDatabaseDao")
    @Autowired
    private UserDao userDao;

    public UserServiceImpl() {
    }

    @Override
    @Transactional(readOnly=true)
    public List<User> getAll() {
        return userDao.getAll();
    }

    @Transactional(readOnly=true)
    @Override
    public User getUserById(Long id) {
        return userDao.getById(id);
    }

    @Transactional(readOnly=true)
    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Transactional
    @Override
    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
          userDao.update(user);
    }

    @Transactional
    @Override
    public void deleteUser(Long id) {
  userDao.remove(userDao.getById(id));
    }

    @Transactional(readOnly=true)
    @Override
    public boolean userExists(String username) {
        return userDao.userExists(username);
    }





}
