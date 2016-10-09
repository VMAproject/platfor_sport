package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.UserDao;
import com.sport.mvc.models.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;


@Repository(value = "userDatabaseDao")
public class UserDatabaseDao extends HibernateAbstractDao<User> implements UserDao {

    public UserDatabaseDao() {

    }

    @Override
    public User getByUsername(String username) {
        Criteria criteria =getSession().createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        return (User) criteria.uniqueResult();
    }
}
