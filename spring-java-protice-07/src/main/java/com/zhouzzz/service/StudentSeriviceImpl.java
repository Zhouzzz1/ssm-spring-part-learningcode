package com.zhouzzz.service;

import com.zhouzzz.dao.StudentDao;
import com.zhouzzz.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentSeriviceImpl implements StudentService{

    @Autowired
    private StudentDao studentDao;
    @Override
    public List<Student> findAll() {
        List<Student> students = studentDao.queryAll();
        return students;
    }
}
