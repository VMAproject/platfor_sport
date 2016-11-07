package com.sport.mvc.services.impl;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service(value = "groupService")
public class GroupServiceImpl implements GroupService {

    @Qualifier("groupDatabaseDao")
    @Autowired
    private GroupDao groupDao;

    public GroupServiceImpl() {
    }

    @Transactional
    public List<Group> getAll() {
        return groupDao.getAll();
    }

    @Override
    @Transactional
    public void addGroup(Group group) {
        groupDao.add(group);
    }


    @Override
    @Transactional
    public void deleteListOfGroup(Long id) {
        groupDao.remove(groupDao.getById(id));
    }

    @Transactional
    @Override
    public Group getGroup(long theId) {
        return  groupDao.getById(theId);
    }

    @Transactional
    public void saveStudentsGroup(){

    }


}
