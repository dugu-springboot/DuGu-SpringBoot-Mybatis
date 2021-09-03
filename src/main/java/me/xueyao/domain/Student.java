package me.xueyao.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Simon.Xue
 * @date 2021-09-03 22:15:06
 **/
@Data
public class Student implements Serializable {
    private Integer id;
    private String creator;
    private String updater;
    private Date createTm;
    private Date updateTm;
    private String no;
    private String name;
    private Integer age;
    private String className;
    private String schoolName;

}
