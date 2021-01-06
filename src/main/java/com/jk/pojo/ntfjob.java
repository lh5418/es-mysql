package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@Document(indexName = "lypjob",type = "job")
public class ntfjob {
    @Id
    private Integer id;
    private String stuName;
    private Integer classId;
    private String info;
    private Integer age;
    private String jobTime;
    private String jobUnit;
    private Integer pay;

    @Transient //临时字段
    private Integer minPay;
    @Transient //临时字段
    private Integer maxPay;
    private String className;
}
