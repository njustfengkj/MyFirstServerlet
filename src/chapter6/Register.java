package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends DBServlet
{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String userName = null;	
		//  ��������������try{...}ǰ�棬��������finally�е�forward,
		//  �ڵ���sendRedirect�����󣬲����ٵ���forward����
		if(request.getParameter("login") != null)
		{
			response.sendRedirect("login.jsp");//  �ض���login.jsp
			return;
		}
		try
		{
			super.service(request, response);//  ����DBServlet��service����
			userName = request.getParameter("username");//  ���username
			String password = request.getParameter("password");//  ���password
			String email = request.getParameter("email");//  ���email
			//  �����֤��
			String validationCode = request.getParameter("validation_code");
			// �û��������벻��Ϊnull
			if(userName == null || password == null || validationCode == null) return;
			// �û����������������
			if(userName.equals("") || password.equals("") || validationCode.equals("")) return;
			//  ���б���ת������֧�������û���
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			
			//  ��result.jsp��Ҫ��ת��register.jspҳ
			request.setAttribute("page", "register.jsp");
			//  �˶���֤��
			if(!checkValidationCode(request, validationCode))
			{
				return;
			}			
			
			email = (email == null)?"":email;// ����ֵ��email��Ϊ�մ�
			
			// ��MD5�㷨�������ַ�������
			String passwordMD5 = common.Encrypter.md5Encrypt(password);
			
			//  ��������¼��SQL���
			String sql = "insert into t_users(user_name, password_md5, email) values(?, ?, ?)";
			//  ִ��SQL���
			execSQL(sql, userName, passwordMD5, email);			
			request.setAttribute("info", "�û�ע��ɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			request.setAttribute("info", userName + "�Ѿ���ʹ��!");
		}
		finally
		{
			//  ת����result.jsp
			RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
			rd.forward(request, response);
		}
	}
}
