package com.niit.web.blog.util;

import lombok.Data;

/**
 * @author mq_xu
 * @ClassName ResponseObject
 * @Description 统一的响应对象，采用了单例模式
 * @Date 9:18 2019/10/9
 * @Version 1.0
 **/

@Data
public class ResponseObject {
    private Integer code;
    private String msg;
    private Object data;

    /*响应成功，将数据存入gson的data中*/
    public static ResponseObject success(Integer code, String msg, Object data) {
        ResponseObject ro = new ResponseObject();
        ro.setCode(code);
        ro.setMsg(msg);
        ro.setData(data);
        return ro;
    }

    public static ResponseObject success(Integer code, String msg) {
        ResponseObject ro = new ResponseObject();
        ro.setCode(code);
        ro.setMsg(msg);
        return ro;
    }
}