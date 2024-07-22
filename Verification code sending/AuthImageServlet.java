package com.ujiuye.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ujiuye.utils.VerifyCodeUtils;


/*
 * ������֤��
 */
@WebServlet("/authImage")
public class AuthImageServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//JSPҳ���ֹ�����ʹ�û��棬��Ϊ��֤��ÿ��ʹ�����ʧЧ
		response.setHeader("Pragma", "No-cache"); 
        response.setHeader("Cache-Control", "no-cache"); 
        response.setDateHeader("Expires", 0); 
        //������Ӧ��������ΪͼƬ
        //response.setContentType("text/html;charset=utf-8");
        response.setContentType("image/jpeg"); 
           
        //��������ִ� 
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4); 
        //����Ựsession 
        HttpSession session = request.getSession(true); 
        //ɾ����ǰ��
        session.removeAttribute("verCode");
        session.setAttribute("verCode", verifyCode.toLowerCase()); 
        //����ͼƬ 
        int w = 100, h = 30; 
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode); 
	}
}
