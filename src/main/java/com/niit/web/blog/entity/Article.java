package com.niit.web.blog.entity;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author jh_wu
 * @ClassName Article
 * @Description TODO
 * @Date 2019/11/14:19:08
 * @Version 1.0
 **/
@Data
public class Article {
    private Long id;
    private Long userId;
    private Long topicId;
    private String title;
    private String summary;
    private String thumbnail;
    private String content;
    private Integer likes;
    private Integer comments;
    private LocalDateTime createTime;
}
