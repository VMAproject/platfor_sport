package com.sport.mvc.dao.impl.file;

import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository(value = "studentFileDao")
public class StudentFileDao extends FileAbstractDao<Student> implements StudentDao {

    public StudentFileDao() {
    }

    @Override
    public String getDataSourceName() {
        return null;
    }

    @Override
    public List<Student> getAll() {
        return null;
    }

    @Override
    public Student getById(Long id) {
        return null;
    }




}
