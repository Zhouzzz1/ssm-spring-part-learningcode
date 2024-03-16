package com.zhouzzz.dao.impl;

import com.zhouzzz.dao.StudentDao;
import com.zhouzzz.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/**
 * .StudentDaoImpl-   jdbcTemplate这个对象进行数据库操作，这个对象在xml进行配置
 */
public class StudentDaoImpl implements StudentDao {

    @Autowired
    /*@Autowired 是一个 Spring 框架的注解，它的作用是自动装配（Autowired）Bean。
    @Autowired 注解被用来注入一个 JdbcTemplate 对象到 StudentDaoImpl 类中。

    JdbcTemplate 是 Spring 框架提供的一个类，它简化了 JDBC 的使用，封装了大量的繁琐操作，
    使得数据库访问更加便捷。它提供了一系列的方法用于执行 SQL 查询、更新操作，处理事务等。
    在StudentDaoImpl 类中，通过将 JdbcTemplate 注入到成员变量中，可以方便地在方法中使用它执行数据库操作，
    如执行 SQL 查询语句。在 queryAll() 方法中，就是利用 JdbcTemplate 来执行 SQL 查询，
    并使用 BeanPropertyRowMapper 将结果集映射为 Student 对象的列表。

    总之，通过 @Autowired 注解将 JdbcTemplate 注入到 StudentDaoImpl 中，
    使得在该类中可以方便地使用 JdbcTemplate 来执行数据库操作，而无需手动创建 JdbcTemplate 实例。
    * */
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> queryAll() {
        String sql = "select id , name , age , gender , class as classes from students ;";

        /*
          query可以返回集合!
          BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
         */
        List<Student> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        /*在 Spring JDBC 中，BeanPropertyRowMapper 是一个实用工具，
        它的主要功能是将 JDBC 返回的 ResultSet 中的行映射到指定的 Java 对象上。
        这个过程是自动化的，它不需要手动编写大量的映射代码。

        现在让我们来看看它是如何工作的：
        反射（Reflection）：
        BeanPropertyRowMapper 使用了 Java 的反射机制。反射允许程序在运行时检查和操作类、方法和属性。
        这允许 BeanPropertyRowMapper 动态地获取和设置类的属性，而无需在代码中显式指定它们。

        列名与属性匹配：
        当从数据库中检索数据时，每一列都有一个名称。例如，在数据库表中，可能有一个名为 id 的列和一个名为 name 的列。
        在 Student 类中，我们可能会有相应的属性。BeanPropertyRowMapper 就是利用这种对应关系来进行映射的。
        例如，它会尝试将数据库中的 id 列的值映射到 Student 类的 id 属性上，将 name 列的值映射到 Student 类的 name 属性上，以此类推。

        对象实例化：
        当 BeanPropertyRowMapper 找到了匹配的属性时，它将使用 Java 的反射机制来实例化目标类（在这里是 Student 类）。
        然后，它会将结果集中的数据填充到相应的属性中，并返回一个包含了这些属性的对象。
        */
        return studentList;
    }
}
