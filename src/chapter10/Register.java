package chapter10;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

public class Register extends HttpServlet
{
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//  ����Content-Type�ֶ�ֵ
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
            // ����ĸ��������ֵ
			String name = request.getParameter("name");
			String password = request.getParameter("password");
			String strAge = request.getParameter("age");
			String strBirthday = request.getParameter("birthday");
            //  ��age�������ֵ��������ת��
			int age = Integer.parseInt(strAge);
            //  �����ʽ�����ڵ���
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
					"yyyy-MM-DD");
			//  ��birthday�������ֵ��������ת��
			Date birthday = format.parse(strBirthday);
			
			UserBean user = new UserBean();//  ����UserBean����ʵ��
			//  ΪUserBean����ʵ�������Ը�ֵ
			user.setName(name);
			user.setPassword(password);
			user.setAge(age);
			user.setBirthday(birthday);
			
            //  ����Ҫ������ͻ��˵�HTML����    
			String html = "";
			html += "<h2>���UserBean������ֵ</h2>";
			html += "<b>";
			html += user.getName() + "<p/>";
			html += user.getPassword() + "<p/>";
			html += user.getAge() + "<p/>";
			html += user.getBirthday() + "<p/>";
			html += "<b/>";
			out.println(html);
		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}

	}

}
