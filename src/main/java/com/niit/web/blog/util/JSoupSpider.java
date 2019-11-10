package com.niit.web.blog.util;

import com.niit.web.blog.entity.Main;
import com.niit.web.blog.entity.User;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author mq_xu
 * @ClassName JSoupSpider
 * @Description JSoup实现的一个爬虫工具
 * @Date 9:13 2019/11/7
 * @Version 1.0
 **/
public class JSoupSpider {
    private static Logger logger = LoggerFactory.getLogger(JSoupSpider.class);

    public static List<Main> getMain() {
        Document document = null;
        List<Main> mainList = new ArrayList<>(100);
         {
            try {
                document = Jsoup.connect("https://www.jianshu.com").get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div -> {
                Element wrapImg = div.child(0);
                Element contentDiv = div.child(1);
                Element meta = contentDiv.child(2);
                Elements jsd =meta.children();
                int i=0;
                Main main = new Main();
                main.setMobile(DataUtil.getMobile());
                main.setPassword(DataUtil.getPassword());
                main.setAuthor(contentDiv.child(2).child(1).text());
                main.setTitle(contentDiv.child(0).text());
                main.setIntroduction(contentDiv.child(1).text());
                main.setAvatar("https:" + wrapImg.child(0).attr("src"));
                main.setDiamond(jsd.get(0).text());
                main.setComments(jsd.get(1).text());
                main.setFans(jsd.get(2).text());
                main.setCreateTime(LocalDateTime.now());
                mainList.add(main);
            });
        }
            System.out.println("成功");
            return mainList;
        }

    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_source=desktop&utm_medium=index-users&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("col-xs-8");
            divs.forEach(div -> {
                Element wrapDiv = div.child(0);
                Element link = wrapDiv.child(0);
                Elements linkChildren = link.children();
                User user = new User();
                user.setMobile(DataUtil.getMobile());
                user.setPassword(DataUtil.getPassword());
                user.setGender(DataUtil.getGender());
                user.setAvatar("https:" + linkChildren.get(0).attr("src"));
                user.setNickname(linkChildren.get(1).text());
                user.setIntroduction(linkChildren.get(2).text());
                user.setBirthday(DataUtil.getBirthday());
                user.setCreateTime(LocalDateTime.now());
                userList.add(user);
            });
        }
        return userList;
    }
}
