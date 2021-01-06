package com.jk.dao;

import com.jk.pojo.CarBean;
import com.jk.pojo.ClassBean;
import com.jk.pojo.EmpBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.TreeBean;
import org.apache.ibatis.annotations.Delete;
import com.jk.pojo.bookBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:21
 */
@Repository
@Mapper
public interface CarDao {
    List<TreeBean> findTreeByPid(int pid);

    void toadd(bookBean book);
    @Delete("delete from t_book where id=#{id}")
    void delJobByIds(Integer id);

    void updateid(bookBean book);

    void addEmp(EmpBean empBean);

    void updateEmp(EmpBean empBean);

    void delEmp(Integer id);

    List<ClassBean> findclass();

    ClassBean findClassById(Integer classid);

    void addStu(StuBean stuBean);

    void updateStu(StuBean stuBean);

    void delStu(Integer id);

    void addCar(CarBean car);

    @Update("update t_car set carName=#{carName},carPrice=#{carPrice} where id=#{id}")
    void updCar(CarBean car);

    @Delete("delete from t_car where id=#{id} ")
    void delById(Integer id);
}
