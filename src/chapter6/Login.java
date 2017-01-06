package chapter6;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.sql.*;

public class Login extends DBServlet
{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//  �������register����������ض���register.jspҳ��
		if (request.getParameter("register") != null)
		{
			response.sendRedirect("register.jsp");
			return;
		}
		String page = "login.jsp";
		String userName = "";
		try
		{			
			super.service(request, response);
			userName = request.getParameter("username");		
			String password = request.getParameter("password");
			String validationCode = request.getParameter("validation_code");
			if (userName == null || password == null || validationCode == null)
				return;
			if (userName.equals("") || password.equals("") || validationCode.equals(""))
				return;
			// �����˱���ת�����Ա�֧�������û���
			userName = new String(userName.getBytes("ISO-8859-1"), "UTF-8");
			// �˶���֤��
			if(!checkValidationCode(request, validationCode))
			{
				return;
			}	 			
			String sql = "select user_name, password_md5 from t_users where user_name = ?";
			// ��ѯ��¼�û��Ƿ����
			ResultSet rs = execSQL(sql, new Object[] { userName });
			if (rs.next() == false)
			{
				//  ����������login.jsp����ʾ���û���������Ϣ
				request.setAttribute("userError", userName + "������");
			}
			else
			{
				//  �õ���¼�û���MD5�����ַ���
				String passwordMD5 = common.Encrypter.md5Encrypt(password);
				if(!rs.getString("password_md5").equals(passwordMD5))
				{
				//  ����������login.jsp����ʾ�����������Ϣ
					request.setAttribute("passwordError", "���벻��ȷ");
				}
				else
				{
					//  ��¼�ɹ�������Ҫת����ҳ��
					page = "/WEB-INF/chapter6/main.jsp";
				}
			}

		}
		catch (Exception e)
		{
			
		}
		finally		
		{
			// ���û���ֻ����request��
			request.setAttribute("username", userName);			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);//  ת����Ӧ��ҳ�棨Ĭ����login.jsp��
		}
	}
}
