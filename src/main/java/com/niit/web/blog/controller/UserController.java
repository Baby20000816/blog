
package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.domain.dto.UserDto;
import com.niit.web.blog.entity.User;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.UserService;
import com.niit.web.blog.util.Message;
import com.niit.web.blog.util.ResponseObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author jh_wu
 * @ClassName UserController
 * @Description TODO
 * @Date 2019/11/9:16:43
 * @Version 1.0
 **/
@WebServlet(urlPatterns = {"/sign-in", "/users", "/users/*"})
public class UserController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService = ServiceFactory.getUserServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*获得前端提交的数据*/
        BufferedReader reader = req.getReader();
        /*新建一个可变的字符序列*/
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        /*通过while循环，一行一行的读入内容*/
        while ((line = reader.readLine()) != null){
            /*将得到的字符放入stringBuilder中*/
            stringBuilder.append(line);
        }
        /*将错误打入日志*/
        logger.info("登录用户信息:" + stringBuilder.toString());
        /*new一个gson*/
        Gson gson = new GsonBuilder().create();
        /*将得到的gson类型数据转换成java类型存入userDto中*/
        UserDto userDto = gson.fromJson(stringBuilder.toString(), UserDto.class);
        /*定义map获取signIn的返回值*/
        Map<String, Object> map = userService.signIn(userDto);
        /*通过map.get方法获得键为msg对应的值*/
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if(msg.equals(Message.SIGN_IN_SUCCESS)){
            /*如果登录成功，取出键为data对应的值*/
            ro = ResponseObject.success(200, msg, map.get("data"));
        }else {
            ro = ResponseObject.success(200, msg);
        }
        /*定义输出流*/
        PrintWriter out = resp.getWriter();
        /*转换为gsons数据并输出*/
        out.print(gson.toJson(ro));
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String requestPath = req.getRequestURI().trim();
        List<User> userList = null;
        User user = null;

        if(requestPath.equals("/users")){
            /*查询所有用户*/
            userList = userService.listUser();
            System.out.println(requestPath);
        }else{
            int position = requestPath.lastIndexOf("/");
            String id = requestPath.substring(position + 1);
            /*进入用户详情页*/
            user = userService.findUserById(Integer.parseInt(id));
        }
        Gson gson = new GsonBuilder().create();
        ResponseObject ro = new ResponseObject();
        ro.setCode(resp.getStatus());
        if(resp.getStatus() == 200){
            ro.setMsg("响应成功");
        }else{
            ro.setMsg("响应失败");
        }

        if(userList!=null) {
            ro.setData(userList);

        }else {
            ro.setData(user);
        }

        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
}