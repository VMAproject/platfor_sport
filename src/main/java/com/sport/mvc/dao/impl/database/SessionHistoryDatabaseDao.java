package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.SessionHistoryDao;
import com.sport.mvc.dao.impl.database.HibernateAbstractDao;
import com.sport.mvc.models.SessionHistory;
import org.springframework.stereotype.Repository;

@Repository(value = "sessionHistoryDatabaseDao")
public class SessionHistoryDatabaseDao extends HibernateAbstractDao<SessionHistory> implements SessionHistoryDao {

    public SessionHistoryDatabaseDao() {
    }

}
