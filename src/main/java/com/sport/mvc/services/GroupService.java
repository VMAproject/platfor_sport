package com.sport.mvc.services;

import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;

import java.util.List;

public interface GroupService {
    List<Group> getAll();

    void addGroup(Group group);

    void deleteListOfGroup(Long id);

    Group getGroup(long theId);


}
