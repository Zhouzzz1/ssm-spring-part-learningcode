package com.zhouzzz.dao;

import com.zhouzzz.pojo.Student;

import java.util.List;

/**
 * 学员持层的访问接口
 */
public interface StudentDao {
    //查询全部学员数据,返回一个集合
    List<Student> queryAll();

}
