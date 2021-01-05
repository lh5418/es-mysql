package com.jk.dao;

import com.jk.pojo.EmpBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘海
 * @create: 2021-01-05 20:19
 */
public interface EmpDao  extends ElasticsearchRepository<EmpBean,Integer> {
}
