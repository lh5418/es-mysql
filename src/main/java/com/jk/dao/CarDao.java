package com.jk.dao;

import com.jk.pojo.EmpBean;
import com.jk.pojo.TreeBean;
import org.apache.ibatis.annotations.Mapper;
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
public interface CarDao {
    List<TreeBean> findTreeByPid(int pid);

    void addEmp(EmpBean empBean);

    void updateEmp(EmpBean empBean);

    void delEmp(Integer id);
}
