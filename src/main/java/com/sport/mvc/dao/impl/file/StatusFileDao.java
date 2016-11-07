package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.StatusDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "statusFileDao")
public class StatusFileDao extends FileAbstractDao<Status> implements StatusDao {

    public StatusFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Status> getAll() {
        return null;
    }

    @Override
    public Status getById(Long id) {
        return null;
    }



}
