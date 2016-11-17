package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.StatusDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Status;
import org.springframework.stereotype.Repository;

@Repository(value = "statusDatabaseDao")
public class StatusDatabaseDao extends HibernateAbstractDao<Status> implements StatusDao {

    public StatusDatabaseDao() {
    }

}
