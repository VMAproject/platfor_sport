package com.sport.mvc.dao;

import com.sport.mvc.models.User;

public interface UserDao extends ItemDao<User> {

    public User getByUsername(String username);

}
