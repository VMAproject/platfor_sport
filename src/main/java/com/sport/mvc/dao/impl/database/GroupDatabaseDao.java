package com.sport.mvc.dao.impl.database;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository(value = "groupDatabaseDao")
public class GroupDatabaseDao extends HibernateAbstractDao<Group> implements GroupDao {


    public GroupDatabaseDao() {
    }


}
