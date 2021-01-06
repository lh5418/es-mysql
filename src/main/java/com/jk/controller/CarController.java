package com.jk.controller;

import com.jk.pojo.ClassBean;
import com.jk.pojo.EmpBean;
import com.jk.pojo.StuBean;
import com.jk.pojo.CarBean;
import com.jk.pojo.TreeBean;
import com.jk.pojo.ntfclass;
import com.jk.pojo.ntfjob;
import com.jk.pojo.bookBean;
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
 * @author: 刘洋朋ss
 * @create: 2021-01-05 19:21
 */
@Controller
@RequestMapping("car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping("show1")
    public String show1(){
        return "show1";
    }
    @RequestMapping("addShow1")
    public String addShow1(){
        return "addShow1";
    }

    /**
     * 树
     * @return
     */
    @RequestMapping("findTree")
    @ResponseBody
    public List<TreeBean> findTree(){
        return carService.findTree();
    }
    //ntf
    @RequestMapping("ntfselect")
    public String selectntf(){
        return "showntf";
    }

    @RequestMapping("ntfadd")
    public String ntfadd(){
        return "ntfadd";
    }



    /**
     * 分页
     * @param page
     * @param rows
     * @param job
     * @return
     */
    @RequestMapping("findNodes")
    @ResponseBody
    public HashMap<String,Object> findNodes(Integer page, Integer rows, ntfjob job){
        return carService.ntffindJob(page,rows,job);
    }

    @RequestMapping("ntfaddJob")
    @ResponseBody
    public void ntfaddTrain(ntfjob job){
        carService.ntfaddJob(job);
    }

    @RequestMapping("ntffindJobById")
    @ResponseBody
    public Optional<ntfjob> ntffindJobById(Integer id){
        return carService.ntffindJobById(id);
    }

    @RequestMapping("ntfdelJobById")
    @ResponseBody
    public void ntfdelJobById(Integer id){
        carService.ntfdelJobById(id);
    }

    @RequestMapping("ntffindClass")
    @ResponseBody
    public List<ntfclass> ntffindClass(){
        return carService.ntffindClass();
    }



    @RequestMapping("deletess")
    @ResponseBody
    public void delJob(Integer id){
        carService.delJob(id);
    }

    @RequestMapping("findcarList")
    @ResponseBody
    public HashMap<String,Object>findcarList(Integer page, Integer rows, bookBean book){
       return carService.findcarList(page,rows,book);
    }

    @RequestMapping("show2")
    public String  toshow(){
        return "show2";

    }
    @RequestMapping("add")
    public String  add(){
        return "add";

    }
    @RequestMapping("toadd")
    @ResponseBody
    public void toadd(bookBean book){
        carService.toadd(book);

    }

    @RequestMapping("delJobById")
    @ResponseBody
    public void delJobById(Integer id){
        carService.delJobById(id);
    }

    @RequestMapping("findJobById")
    @ResponseBody
    public Optional<bookBean> findJobById(Integer id){
        return carService.findJobById(id);
    }


    /**
     * 查询
     * @param page
     * @param rows
     * @param car
     * @return
     */
    @RequestMapping("findCar")
    @ResponseBody
    public HashMap<String,Object> findCar(Integer page, Integer rows, CarBean car){
        return carService.findCar(page,rows,car);
    }

    /**
     * 新增修改
     * @param car
     */
    @RequestMapping("addCar")
    @ResponseBody
    public void addCar(CarBean car){
        carService.addCar(car);
    }

    /**
     * 回显
     * @param id
     * @return
     */
    @RequestMapping("findCarById")
    @ResponseBody
    public Optional<CarBean> findCarById(Integer id){
        return carService.findCarById(id);
    }

    /**
     * 删除
     * @param id
     */
    @RequestMapping("delCarById")
    @ResponseBody
    public void delCarById(Integer id){
        carService.delCarById(id);
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
