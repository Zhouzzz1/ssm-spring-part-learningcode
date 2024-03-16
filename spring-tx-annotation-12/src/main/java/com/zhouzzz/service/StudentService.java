package com.zhouzzz.service;

import com.zhouzzz.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

@Transactional()
@Service
public class StudentService {
    
    @Autowired
    private StudentDao studentDao;


    /**
     * 添加事务:
     *        @Transactional
     *        位置：类上 方法上
     *        方法：当前方法
     *        类上：类下的所有方法都有事务
     *
     *
     *  1.只读模式
     *      只读模式可以提升查询事务的效率！ 推荐事务中只有查询代码，使用只读模式
     *      默认：boolean readOnly() default false;
     *      解释：一般情况下。都是通过类添加注解添加事务
     *              类下的所有方法都有事务
     *              查询方法可以通过再次添加注解，设置为只读模式，提高效率
     *   2.超时时间
     *        默认：永不超时   -1
     *        设置timeout = 时间 秒数 超过时间，就会回滚事务和释放异常 TransactionTimedOutException
     *        如果类上设置了事务属性，方法也设置了事务注解，方法会不会生效
     *        不会生效，方法上的注解覆盖了类上的注解
     *    3.指定异常回滚和指定异常不回滚
     *         默认情况下，指定发生运行时异常事务才会回滚
     *         我们可以指定Exception异常(指定父异常回滚，子异常也回滚)，来控制所有异常都回滚
     *         rollbackFor = Exception.class
     *         nollrollbackFor =回滚异常范围内，控制某个异常不回滚
     *    4.隔离级别设置
     *          推荐设置第二个隔离级别设置 isolation = Isolation.READ_COMMITTED
     */
    @Transactional(timeout = 3,rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void changeInfo(){
        studentDao.updateAgeById(88,1);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("-----------");
        studentDao.updateNameById("test2",1);
    }

    @Transactional(readOnly = true)
    public void getStudentInfo(){
        //查询没必要添加事务，但是为什么还要加呢，看上面解释
        //获取学生信息 查询数据库 不修改

    }
}