package com.sport.mvc.dao.impl;

import com.sport.mvc.dao.SportDao;
import com.sport.mvc.models.Sport;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "SportFileDao")
public class SportFileDao extends FileAbstractDao<Sport> implements SportDao {

    public SportFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Sport> getAll() {
        return null;
    }

    @Override
    public Sport getById(Long id) {
        return null;
    }
}
