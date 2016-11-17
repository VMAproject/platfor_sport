package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.CustomerCardDao;
import com.sport.mvc.models.CustomerCard;
import org.springframework.stereotype.Repository;

@Repository(value = "customerCardDatabaseDao")
public class CustomerCardDatabaseDao extends HibernateAbstractDao<CustomerCard> implements CustomerCardDao {

    public CustomerCardDatabaseDao() {
    }
}
