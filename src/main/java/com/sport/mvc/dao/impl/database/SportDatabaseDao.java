package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.SportDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.Sport;
import org.springframework.stereotype.Repository;

@Repository(value = "sportDatabaseDao")
public class SportDatabaseDao extends HibernateAbstractDao<Sport> implements SportDao {

    public SportDatabaseDao() {
    }

}
