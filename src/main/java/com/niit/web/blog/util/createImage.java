package com.niit.web.blog.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

/**
 * @author jh_wu
 * @ClassName createImage
 * @Description TODO
 * @Date 2019/11/19:15:05
 * @Version 1.0
 **/
public class  createImage {
    public static BufferedImage createImage(int width,int height,String s) {
        BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D) img.getGraphics();

        graphics.setBackground(Color.GRAY);
        graphics.fillRect(0, 0, width, height);
        graphics.setPaint(Color.orange);
        Font font = new Font("Serif", Font.BOLD, 10);
        graphics.setFont(font);
        graphics.drawString(s, width / 6, height / 3);
        return img;
    }

    public static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }

    public static void main(String[] args) throws Exception{
        BufferedImage img = createImage.createImage(120,35,Code.code());
        File file = new File("E:/code1.jpg");
        ImageIO.write(img,"jpg",file);

    }
}
