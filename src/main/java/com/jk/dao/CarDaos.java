package com.jk.dao;

import com.jk.pojo.CarBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 20:38
 */
public interface CarDaos extends ElasticsearchRepository<CarBean,Integer> {
}
