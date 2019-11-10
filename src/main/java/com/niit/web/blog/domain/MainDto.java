package com.niit.web.blog.domain;

import lombok.Data;

/**
 * @author jh_wu
 * @ClassName MainDto
 * @Description TODO
 * @Date 2019/11/9:20:42
 * @Version 1.0
 **/
@Data
public class MainDto {
    private String mobile;
    private String password;

    public MainDto(String mobile, String password) {
        this.mobile = mobile;
        this.password = password;
    }

    public MainDto() {
    }
}
