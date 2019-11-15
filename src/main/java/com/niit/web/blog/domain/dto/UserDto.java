package com.niit.web.blog.domain.dto;

import lombok.Data;

/**
 * @author mq_xu
 * @ClassName UserDto
 * @Description TODO
 * @Date 12:20 2019/11/9
 * @Version 1.0
 **/
@Data
public class UserDto {
    private String mobile;
    private String password;

    public UserDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public UserDto() {
    }
}
