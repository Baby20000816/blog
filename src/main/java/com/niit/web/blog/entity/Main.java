package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jh_wu
 * @ClassName Main
 * @Description TODO
 * @Date 2019/11/9:18:52
 * @Version 1.0
 **/
@Data
public class Main {
    private Long id;
    private String mobile;
    private String password;
    private String author;
    private String title;
    private String introduction;
    private String avatar;
    private String diamond;
    private String comments;
    private String fans;
    private LocalDateTime createTime;
}
