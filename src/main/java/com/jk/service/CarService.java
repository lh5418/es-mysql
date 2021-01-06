package com.jk.service;

import com.jk.pojo.CarBean;
import com.jk.pojo.ClassBean;
import com.jk.pojo.EmpBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.ntfclass;
import com.jk.pojo.ntfjob;
import com.jk.pojo.bookBean;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:22
 */
public interface CarService {
    List<TreeBean> findTree();

    HashMap<String, Object> ntffindJob(Integer page, Integer rows, ntfjob job);

    void ntfaddJob(ntfjob job);

    Optional<ntfjob> ntffindJobById(Integer id);

    void ntfdelJobById(Integer id);

    List<ntfclass> ntffindClass();

    void delJob(Integer id);

    HashMap<String, Object> findCar(Integer page, Integer rows, CarBean car);

    void addCar(CarBean car);

    Optional<CarBean> findCarById(Integer id);

    void delCarById(Integer id);

    HashMap<String, Object> findcarList(Integer page, Integer rows, bookBean book);

    void toadd(bookBean book);

    void delJobById(Integer id);

    Optional<bookBean> findJobById(Integer id);

    HashMap<String, Object> efindTable(Integer page, Integer rows, EmpBean empBean);

    void addEmp(EmpBean empBean);

    Optional<EmpBean> findEmp(Integer id);

    void delEmp(Integer id);

    List<ClassBean> findclass();

    StuBean findStu(Integer id);

    void addStu(StuBean stuBean);

    void delStu(Integer id);

    HashMap<String, Object> initTable(Integer page, Integer rows, StuBean stuBean);
}
