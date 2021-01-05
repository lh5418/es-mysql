package com.jk.pojo;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "stu",type = "2006a")
public class StuBean {
    @Id
    private Integer id;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;
    @Field(type = FieldType.Keyword)
    private Integer classid;
    @Field(type = FieldType.Keyword)
    private String info;
    @Field(type = FieldType.Keyword)
    private Integer age;
    @Field(type = FieldType.Keyword)
    private Integer salary;
    @Field(type = FieldType.Keyword)
    private String time;
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String util;

    @Field(type = FieldType.Keyword)
    private String classname;

    @Transient
    private String yewu;
    @Transient
    private Integer minsalary;
    @Transient
    private Integer maxsalary;
}
