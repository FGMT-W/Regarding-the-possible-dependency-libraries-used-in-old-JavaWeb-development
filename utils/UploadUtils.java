/**
 * 
 */
package com.ujiuye.utils;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/** 
* @Title: UploadUtils.java
* @author: yanbo.deng
* @date: 2019年9月15日 上午8:34:06
* @Description:封装文件上传的工具类
*/
public class UploadUtils {
	
	public static String uploadFile(Part part,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//保存上传的文件名
		String photo=null;
		//获取上传表单信息
		String header = part.getHeader("Content-Disposition");
		photo=header.substring(header.lastIndexOf("filename")+10, header.length()-1);
		//System.out.println(photo);
		//使用UUID生成随机文件名,避免同名文件替换
		photo=UUID.randomUUID()+photo;	
		//获取文件后缀名
		String type=photo.substring(photo.lastIndexOf(".")+1);
		//判断文件类型是否是图片
		if (!("jpg".equals(type)||"png".equals(type)||"jpeg".equals(type))) {
			request.setAttribute("msg", "文件格式不是图片！");
			try {
				request.getRequestDispatcher("regist.jst").forward(request, response);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
			//如果文件格式不正确则将图片名称给空值
			return photo="";
		}
		//上传文件路径
		String path="F:/xmpic";
		//System.out.println(path);
		//创建上传路径
		File file=new File(path);
		if (!file.exists()) {
			file.mkdir();
		}
		//将文件保存到指定目录中
		try {
			part.write(path+"/"+photo);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return photo;
	}	
}
