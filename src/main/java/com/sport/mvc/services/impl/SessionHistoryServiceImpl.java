package com.sport.mvc.services.impl;

import com.sport.mvc.dao.SessionHistoryDao;
import com.sport.mvc.models.SessionHistory;
import com.sport.mvc.services.SessionHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "sessionHistoryServiceImpl")
public class SessionHistoryServiceImpl implements SessionHistoryService{

    @Qualifier("sessionHistoryDatabaseDao")
    @Autowired
    private SessionHistoryDao sessionHistoryDao;

    public SessionHistoryServiceImpl() {
    }

    @Override
    @Transactional
    public void addSession(SessionHistory sessionHistory) {
        sessionHistoryDao.add(sessionHistory);
    }
}
