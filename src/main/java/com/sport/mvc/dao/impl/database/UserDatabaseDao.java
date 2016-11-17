package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.UserDao;

import com.sport.mvc.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

    public UserDatabaseDao() {
    }


    @Override
    public boolean addUser(User user) {
        try {

        getSession().save(user);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean userExists(String username) {
        List<User> userList = getSession().createQuery("FROM User").list();
        return userList.size()>0 ? true : false;
    }


    @Override
//    @Query("FROM User u WHERE u.username = ")
    public User getUserByUsername(String userName) {
        String likeName="'"+userName+"'";
        List<User> userList = getSession().createQuery("FROM User u WHERE u.username = "+likeName).list();

        if (userList.size()>0) {
            User user = userList.get(0);
            return user;
        }else {
            System.out.println("User Not Found");
            return null;
        }
    }
}
