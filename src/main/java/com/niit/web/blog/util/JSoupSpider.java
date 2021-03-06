
package com.niit.web.blog.util;

import com.niit.web.blog.entity.Address;
import com.niit.web.blog.entity.Article;
import com.niit.web.blog.entity.Topic;
import com.niit.web.blog.entity.User;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
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

    /*爬取用户信息*/
    public static List<User> getUsers() {
        Document document = null;
        List<User> userList = new ArrayList<>(100);
        for (int i = 1; i <= 3; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/recommendations/users?utm_s" +
                        "ource=desktop&utm_medium=index-users&page=" + i).get();
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

    /*爬取地址信息*/
    public static List getAddress() {
        List<Address> addressList = new ArrayList<>();
        Document document = null;
        try {
            document = Jsoup.connect("http://www.ip33.com/area_code.html").get();
        } catch (IOException e) {
            logger.error("获取地址连接异常");
        }
        Elements divs = document.getElementsByClass("ip");
        divs.forEach(div -> {
            Elements elements = div.child(1).child(0).child(1).children();
            elements.forEach(element -> {
                Address address = new Address();
                StringBuilder province = new StringBuilder("");
                String country = div.child(1).child(0).child(0).text();
                int c = country.indexOf(" ");
                int p = div.child(0).text().indexOf(" ");
                int e = element.text().indexOf(" ");
                province.append(div.child(0).text().substring(0, p)).append(country.substring(0, c)).append(element.text().substring(0, e));
                address.setAddress(province.toString());
                addressList.add(address);
            });

        });

        return addressList;
    }

    /*爬取文章信息*/
    public static List<Article> getArticles() {
        Document document = null;
        List<Article> articleList = new ArrayList<>(100);
        for (int i = 1; i < 10; i++) {
            try {
                document = Jsoup.connect("https://www.jianshu.com/c/87b50a03a96e?order_by=top&count=50&page=" + i).get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            Elements divs = document.getElementsByClass("have-img");
            divs.forEach(div -> {
                String articleUrl = div.child(0).attr("href");
                Document document1 = null;
                try {
                    document1 = Jsoup.connect("https://www.jianshu.com" + articleUrl).get();
                } catch (IOException e) {
                    logger.error("连接失败");
                }
                Element articleElement = document1.getElementsByClass("_2rhmJa").first();
                Article article = new Article();
                article.setContent(articleElement.html());

                Elements elements = div.children();
                Element linkElement = elements.get(0);
                Element divElement = elements.get(1);
                article.setUserId(DataUtil.getUserId());
                article.setTitle(divElement.child(0).text());
                article.setSummary(divElement.child(1).text());
                String img = "https:" + linkElement.child(0).attr("src");
                int index = img.indexOf("?");
                article.setThumbnail(img.substring(0, index));
                Elements metaChildren = divElement.child(2).children();
                String comments = metaChildren.get(2).text();
                String likes = metaChildren.last().text();
                try {
                    article.setComments(Integer.parseInt(comments));
                    article.setLikes(Integer.parseInt(likes));
                } catch (NumberFormatException e) {
                    logger.error("格式转换异常");
                }
                article.setCreateTime(DataUtil.getCreateTime());
                articleList.add(article);
            });
        }
        System.out.println(articleList.size());
        return articleList;
    }

    /*爬取简书网专题*/
    public static List<Topic> getTopics() {
        List<Topic> topicList = new ArrayList<>(100);
        Connection connection;
        Document document = null;
        for(int i = 1; i <= 3; i++){
            try {
                /*分析页面，得到url和参数*/
                connection = Jsoup.connect("https://www.jianshu.com/recommendations/collections?order_by=hot&page=" + i);
                /*通过chorme开发者工具查看该请求头必须添加请求头*/
                connection.header("X-PJAX", "true");
                document = connection.get();
            } catch (IOException e) {
                logger.error("连接失败");
            }
            assert document != null;
            Elements list = document.select(".collection-wrap");
            list.forEach(item ->{
                Elements elements = item.children();
                Topic topic = new Topic();
                Element link = elements.select("a").get(0);
                Element logo = link.child(0);
                Element name = link.child(1);
                Element description = link.child(2);
                Element articles = elements.select(".count > a").get(0);
                Element follows = elements.select(".count > a").get(0);
//                topic.setAuthorId(DataUtil.getAuthorId());
                topic.setName(name.text());
                topic.setLogo(logo.attr("src"));
                topic.setDescription(description.text());
                String [] str = StringUtil.getDigital(articles.text());
                topic.setArticles(Long.parseLong(str[0]));
                str = StringUtil.getDigital(follows.text());
                topic.setFollows(Integer.parseInt(str[0]));
                topic.setUpdateTime(LocalDate.now());
                topicList.add(topic);
            });
        }
        return topicList;
    }
}