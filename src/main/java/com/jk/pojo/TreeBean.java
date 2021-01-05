package com.jk.pojo;

import lombok.Data;

import java.util.List;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:27
 */
@Data
public class TreeBean {
    private Integer id;
    private String text;
    private Integer pid;
    private String href;//路径
    private List<TreeBean> nodes;//树节点
    private Boolean selectable;//是否打开选项卡页面 ：true打开  false不打开
}
