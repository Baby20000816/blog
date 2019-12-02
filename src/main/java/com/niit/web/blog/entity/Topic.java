package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Topic {
    private Integer id;
    private Long authorId;
    private String name;
    private String logo;
    private String description;
    private Integer follows;
    private Long articles;
    private LocalDate updateTime;
}