package com.zhouzzz.service;

import com.zhouzzz.pojo.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {
    List<Student> findAll();
}
