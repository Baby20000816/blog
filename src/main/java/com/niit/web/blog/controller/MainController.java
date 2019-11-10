package com.niit.web.blog.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.niit.web.blog.domain.MainDto;
import com.niit.web.blog.factory.ServiceFactory;
import com.niit.web.blog.service.MainService;
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
import java.util.Map;

/**
 * @author jh_wu
 * @ClassName MainController
 * @Description TODO
 * @Date 2019/11/9:21:00
 * @Version 1.0
 **/
@WebServlet(urlPatterns = "/sign-in")
public class MainController extends HttpServlet {
    private static Logger logger = LoggerFactory.getLogger(MainController.class);
    private MainService mainService = ServiceFactory.getMainServiceInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BufferedReader reader = req.getReader();
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        logger.info("登录用户信息：" + stringBuilder.toString());
        Gson gson = new GsonBuilder().create();
        MainDto mainDto = gson.fromJson(stringBuilder.toString(), MainDto.class);
        Map<String, Object> map = mainService.signIn(mainDto);
        String msg = (String) map.get("msg");
        ResponseObject ro;
        if (msg.equals(Message.SIGN_IN_SUCCESS)) {
            ro = ResponseObject.success(200, msg, map.get("data"));
        } else {
            ro = ResponseObject.success(200, msg);
        }
        PrintWriter out = resp.getWriter();
        out.print(gson.toJson(ro));
        out.close();
    }
    @Override
    public void init() throws ServletException {
        logger.info("UserController初始化");
    }
}