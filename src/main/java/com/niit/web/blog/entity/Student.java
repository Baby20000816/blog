package com.niit.web.blog.entity;

import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author jh_wu
 * @ClassName Student
 * @Description TODO
 * @Date 2019/11/5:15:13
 * @Version 1.0
 **/
@Data
public class Student {
    private Integer id;
    private String username;
    private String avatar;
    private String describe;
    private LocalDateTime createTime;
}
