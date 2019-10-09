package servletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @ Author     ：gaols
 * @ Date       ：Created in 16:03 2019/8/28
 * @Version: $version$
 * 文件下载需求：
 * 		1. 页面显示超链接
 * 		2. 点击超链接后弹出下载提示框
 * 		3. 完成图片文件下载
 */
@WebServlet("/downloadServlet")
public class downloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String filename = request.getParameter("filename");
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/img/" + filename);
        String mimeType = servletContext.getMimeType(filename);
        response.setHeader("content-type",mimeType);
        response.setHeader("content-disposition","attachment;filename="+filename);
        FileInputStream fileInputStream=new FileInputStream(realPath);
        byte[] bytes = new byte[1024*10];
        int len=0;
        ServletOutputStream outputStream = response.getOutputStream();
        while ((len=fileInputStream.read(bytes))!=-1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
    }
}
