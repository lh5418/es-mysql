package com.jk.dao;

import com.jk.pojo.CarBean;
import com.jk.pojo.ClassBean;
import com.jk.pojo.EmpBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.ntfclass;
import com.jk.pojo.ntfjob;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Delete;
import com.jk.pojo.bookBean;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

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

    @Select("select * from t_class where classId=#{classId}")
    ntfclass ntffindClassName(Integer classId);
///新增
    void ntfaddJob(ntfjob job);

    @Update("update t_job set stuName=#{stuName},classId=#{classId},info=#{info},age=#{age} where id = #{id}")
    void ntfupdJob(ntfjob job);

    @Select("select * from t_job where id=#{value}")
    Optional<ntfjob> ntffindById(Integer id);
    @Delete("delete from t_class where id=#{id}")
    void ntfdelJobByIds(Integer id);

    @Select("select * from t_class")
    List<ntfclass> ntffindClass();

    void ntfdeleteById(Integer id);

    void ntfsave(ntfjob job);

    int selectCount(ntfjob job);

    List select(@Param("start") int start,@Param("end") int end,@Param("job") ntfjob job);
    @Delete("delete from t_job where id  = #{value}")
    void delJob(Integer id);
}
