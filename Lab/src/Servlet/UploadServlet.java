package Servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import Entity.FILE;
import SERVICE.parUser;



/**
 * Servlet implementation class docTest
 */
@WebServlet("/up")
@MultipartConfig  //使用MultipartConfig注解标注改servlet能够接受文件上传的请求
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset-utf-8");
		
        Part part = request.getPart("myfile");
        String disposition = part.getHeader("Content-Disposition");
        String suffix = disposition.substring(disposition.lastIndexOf("."),disposition.length()-1);
          //随机的生存一个32的字符串
        String filename = UUID.randomUUID()+suffix;
          //获取上传的文件名
        InputStream is = part.getInputStream();
        //动态获取服务器的路径
        String serverpath = request.getServletContext().getRealPath("upload");
        System.out.println("serverpath"+serverpath);
        FileOutputStream fos = new FileOutputStream(serverpath+"/"+filename);
        System.out.println("filename="+filename);
        
//        fileCon
		String name=request.getParameter("fileCon");//文件名字
		String name_fileString="upload\\"+filename;
		String ownerString=request.getParameter("owner");
		FILE file1=new FILE(filename,name,name_fileString,ownerString);
		//将这个对象添加到数据库中去
		int count=parUser.insertFILE1(file1);
		System.out.println("添加成功的count = "+count);
		//成功或者失败的重定向
        byte[] bty = new byte[1024];
        int length =0;
        while((length=is.read(bty))!=-1){
            fos.write(bty,0,length);
        }
        fos.close();
        is.close();
        response.sendRedirect("upload.jsp");
    }
}
