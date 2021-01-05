package com.jk.service.impl;

import com.jk.dao.CarDao;
import com.jk.pojo.TreeBean;
import com.jk.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:22
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<TreeBean> findTree() {
        int pid=0;
        List<TreeBean> list = findNodes(pid);
        return list;
    }

    private List<TreeBean> findNodes(int pid) {
        List<TreeBean> list = carDao.findTreeByPid(pid);
        for (TreeBean tree : list) {
            Integer id = tree.getId();
            List<TreeBean> nodelist = findNodes(id);//递归自己调自己
            //判断是否有子节点：有子节点-->打开  false  没有子节点-->不能打开 true
            if(nodelist!=null&&nodelist.size()>0){//有子节点
                tree.setNodes(nodelist);
                tree.setSelectable(false);//有子节点-->打开  false
            }else{//没有子节点
                tree.setSelectable(true);//没有子节点-->不能打开 true
            }
        }
        return list;
    }
}
