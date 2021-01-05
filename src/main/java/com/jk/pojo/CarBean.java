package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘洋朋
 * @create: 2021-01-05 19:22
 */
@Data
@Document(indexName = "lypcar",type = "car")
public class CarBean {
    @Id
    private Integer id;
    private String carName;
    private Integer carPrice;

    @Transient //临时字段
    private Integer minPay;
    @Transient //临时字段
    private Integer maxPay;
}
