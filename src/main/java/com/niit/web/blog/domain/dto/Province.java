package com.niit.web.blog.domain.dto;

import lombok.Data;

import java.util.List;

/**
 * @author jh_wu
 * @ClassName Province
 * @Description TODO
 * @Date 2019/11/14:19:41
 * @Version 1.0
 **/
@Data
public class Province {
    private String name;
    private String level;
    private String code;
    private List<City> cities;
}
