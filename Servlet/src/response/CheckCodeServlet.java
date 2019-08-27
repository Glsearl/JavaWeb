package response;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 14:49 2019/8/27
 * @Version: $version$
 * 图片验证码
 */
@WebServlet("/checkCodeServlet")
public class CheckCodeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width=100;
        int height=50;
        //1.创建一对象，在内存中图片(验证码图片对象)
        BufferedImage image=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //2.美化图片
        //2.1 填充背景色
        Graphics graphics = image.getGraphics();
        graphics.setColor(Color.PINK);
        graphics.fillRect(0,0,width,height);
        //2.2画边框
        graphics.setColor(Color.BLUE);
        graphics.drawRect(0,0,width-1,height-1);
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghigklmnopqrstuvwxyz0123456789";
        //生成随机角标
        Random random=new Random();
        for (int i = 1; i <= 4; i++) {
            int index = random.nextInt(str.length());
            //获取字符
            char ch = str.charAt(index);//随机字符
            //2.3写验证码
            graphics.drawString(ch+"",width/5*i,height/2);
        }
        //2.4画干扰线
        graphics.setColor(Color.GREEN);

        //随机生成坐标点

        for (int i = 0; i < 10; i++) {
            int x1 = random.nextInt(width);
            int x2 = random.nextInt(width);

            int y1 = random.nextInt(height);
            int y2 = random.nextInt(height);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //将图片输出到浏览器上
        ImageIO.write(image,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   this.doPost(request,response);
    }
}
