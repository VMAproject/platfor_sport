package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.SessionHistoryDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.SessionHistory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "sessionHistoryFileDao")
public class SessionHistoryFileDao extends FileAbstractDao<SessionHistory> implements SessionHistoryDao {

    public SessionHistoryFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<SessionHistory> getAll() {
        return null;
    }

    @Override
    public SessionHistory getById(Long id) {
        return null;
    }


}
