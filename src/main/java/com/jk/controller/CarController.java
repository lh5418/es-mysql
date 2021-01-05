package com.jk.controller;

import com.jk.pojo.ClassBean;
import com.jk.pojo.EmpBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.TreeBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:21
 */
@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("findTree")
    @ResponseBody
    public List<TreeBean> findTree(){
        return carService.findTree();
    }


    /**
     * @Author lh 
     * @Description  show页面
     * @Date 20:10 2021/1/5
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("show3")
    public String show3(){
        return "show3";
    }

    /**
     * @Author lh
     * @Description  查询
     * @Date 20:09 2021/1/5
     * @Param [page, rows, empBean]
     * @return java.util.HashMap<java.lang.String,java.lang.Object>
     **/
    @RequestMapping("efindTable")
    @ResponseBody
    public HashMap<String,Object> efindTable(Integer page, Integer rows, EmpBean empBean){
        return  carService.efindTable(page,rows,empBean);
    }

    /**
     * @Author lh 
     * @Description  删除
     * @Date 20:21 2021/1/5
     * @Param [id]
     * @return void
     **/
    @RequestMapping("delEmp")
    @ResponseBody
    public void delEmp(Integer id){
        carService.delEmp(id);
    }

    /**
     * @Author lh 
     * @Description  修改回显
     * @Date 20:22 2021/1/5
     * @Param [id]
     * @return java.util.Optional<com.jk.pojo.EmpBean>
     **/
    @RequestMapping("findEmp")
    @ResponseBody
    public Optional<EmpBean> findEmp(Integer id){
        return  carService.findEmp(id);
    }

    /**
     * @Author lh
     * @Description
     * @Date 20:22 2021/1/5
     * @Param []
     * @return java.lang.String
     **/
    @RequestMapping("toadd3")
    public String toadd3(){
        return "addEmp";
    }

    /**
     * @Author lh
     * @Description  新增
     * @Date 20:23 2021/1/5
     * @Param [empBean]
     * @return void
     **/
    @RequestMapping("addEmp")
    @ResponseBody
    public void addEmp(EmpBean empBean){
        carService.addEmp(empBean);
    }

    @RequestMapping("ban")
    public String ban(){
        return "ban";
    }

    @RequestMapping("stu")
    public String stu(){
        return "stu";
    }


    @RequestMapping("initTable")
    @ResponseBody
    public HashMap<String, Object> initTable(Integer page, Integer rows, StuBean stuBean) {
        return carService.initTable(page, rows, stuBean);
    }

    @RequestMapping("findclass")
    @ResponseBody
    public List<ClassBean> findclass(){
        return carService.findclass();
    }

    @RequestMapping("findStu")
    @ResponseBody
    public StuBean findStu(Integer id){
        return carService.findStu(id);
    }

    @RequestMapping("addStu")
    @ResponseBody
    public void addStu(StuBean stuBean){
        carService.addStu(stuBean);
    }

    @RequestMapping("delStu")
    @ResponseBody
    public void delStu(Integer id){
        carService.delStu(id);
    }

    @RequestMapping("toAdd")
    public String toAdd() {
        return "addStu";
    }
}
