package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.dao.impl.file.FileAbstractDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "groupFileDao")
public class GroupFileDao extends FileAbstractDao<Group> implements GroupDao {

    public GroupFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Group> getAll() {
        return null;
    }

    @Override
    public Group getById(Long id) {
        return null;
    }




}
