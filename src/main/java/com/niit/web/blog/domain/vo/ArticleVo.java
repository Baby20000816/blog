package com.niit.web.blog.domain.vo;

import lombok.Data;
import com.niit.web.blog.entity.Article;
import lombok.Data;
import java.time.LocalDateTime;

/**
 * @author jh_wu
 * @ClassName ArticleVo
 * @Description TODO
 * @Date 2019/11/14:19:03
 * @Version 1.0
 **/
@Data
public class ArticleVo  {
    private Long id;
    private Long userId;
    private String nickname;
    private String avatar;
    private String title;
    private String summary;
    private String thumbnail;
    private Integer likes;
    private Integer comments;
}
