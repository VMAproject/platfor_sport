package com.sport.mvc.services.impl;

import com.sport.mvc.dao.GroupDao;
import com.sport.mvc.dao.StudentDao;
import com.sport.mvc.models.Group;
import com.sport.mvc.models.Student;
import com.sport.mvc.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service(value = "studentService")
public class StudentServiceImpl implements StudentService {

    @Qualifier("studentDatabaseDao")
    @Autowired
    private StudentDao studentDao;

    public StudentServiceImpl() {
    }


    @Transactional
    public List<Student> getAll() {
        return studentDao.getAll();
    }





    //method, who return list only student with age>16
    @Override
    @Transactional
    public List<Student> getStudentAgeAfterSixteen(){

        List<Student> afterSixteenList = new ArrayList<>();

        for (Student s:getAll()){

            if (s.getAge()==null||s.getAge().equals("")){

                continue;
            }
            int age =Integer.parseInt(s.getAge());
            if(age>=16){

                afterSixteenList.add(s);
            }
        }
        return afterSixteenList;
    }

    // method, who return list only student with age<16
    @Override
    @Transactional
    public List<Student> getStudentAgeBeforSixteen(){

        List<Student> beforeSixteenList = new ArrayList<>();

        for (Student s:getAll()){
            if (s.getAge()==null||s.getAge().equals("")){
                continue;
            }
            int age =Integer.parseInt(s.getAge());
            if (age < 16) {
                beforeSixteenList.add(s);

            }
        }
        return beforeSixteenList;
    }




    @Transactional
    public List<Student> getStudentByOnlyUnknownStudent(){
        List<Student> unknownPhoneList =new ArrayList<>();
        for (Student s: studentDao.getAll()){
            System.out.println(s.getName()+" "+ s.getSurname()+"  "+s.getEmail());
            if(!s.getName().equals("") || !s.getSurname().equals("") || !s.getEmail().equals("") ||
                    !(s.getName()==null) || !(s.getSurname()==null) || !(s.getEmail()==null)){
                continue;
            }
                unknownPhoneList.add(s);

        }
        return  unknownPhoneList;
    }



    @Override
    @Transactional
    public void addStudent(Student student) {
        studentDao.add(student);
    }

    @Override
    @Transactional
    public void updateStudent(Student student) {
        studentDao.update(student);

    }

    @Override
    @Transactional
    public  void deleteListOfStudents(Long id) {
        studentDao.remove(studentDao.getById(id));

    }

    @Transactional
    @Override
    public Student getStudent(long theId) {
     return  studentDao.getById(theId);
}
        }

