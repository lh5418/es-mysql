package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @program: es-mysql
 * @description:
 * @author: 刘海
 * @create: 2021-01-05 20:01
 */
@Data
@Document(indexName = "emp",type = "2006a")
public class EmpBean {
    @Id
    private Integer id;
    @Field(type = FieldType.Keyword,analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Keyword)
    private Integer salary;
    @Field(type = FieldType.Keyword)
    private String time;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String zname;

    @Transient
    private String yewu;
}
