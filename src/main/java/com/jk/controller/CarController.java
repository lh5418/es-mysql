package com.jk.controller;

import com.jk.pojo.TreeBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

}
