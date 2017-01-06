package chapter11.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Register extends HttpServlet
{
	private boolean validateDate(String date)
	{

		int pos1 = date.indexOf("-");
		int pos2 = date.indexOf("-", pos1 + 1);

		int year = Integer.parseInt(date.substring(0, pos1));

		int month = Integer.parseInt(date.substring(pos1 + 1, pos2));
		int day = Integer.parseInt(date.substring(pos2 + 1));
		if (month < 1 || month > 12)
		{
			return false;
		}
		if (day < 1 || day > 31)
		{
			return false;
		}
		if ((month == 4 || month == 6 || month == 9 || month == 11)
				&& (day == 31))
		{
			return false;
		}
		if (month == 2)
		{
			boolean leap = (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
			if (day > 29 || (day == 29 && !leap))
			{
				return false;
			}
		}

		return true;
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
	
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String strAge = request.getParameter("age");
			String strBirthday = request.getParameter("birthday");
			int age = -1;
			java.util.Date birthday = null;
			String errorMsg = "";
			if (username == null || username.trim().equals(""))
			{
				errorMsg = "�û�����������!";
			}
			else if (!username.trim().matches("^\\w*$"))
			{
				errorMsg = "�û�����������ĸ������!";
			}
			else if (username.trim().length() < 4
					|| username.trim().length() > 20)
			{
				errorMsg = "�û����ĳ��ȱ������4��20֮��!";
			}
			else if (password == null || password.trim().equals(""))
			{
				errorMsg = "�����������!";
			}
			else if (password.trim().length() < 8
					|| password.trim().length() > 30)
			{
				errorMsg = "����ĳ��ȱ������8��30֮��!";
			}
			else if (strAge == null || strAge.trim().equals(""))
			{
				errorMsg = "���������������!";
			}
			else if (!strAge.trim().matches("^[0-1]?[0-9]?[0-9]$"))
			{
				errorMsg = "����������һ����Ч������!";
			}
			else if (strBirthday == null || strBirthday.trim().equals(""))
			{
				errorMsg = "�������ڱ�������!";
			}
			else
			{
				age = Integer.parseInt(strAge);
				try
				{

					if (!validateDate(strBirthday))
						errorMsg = "�����������벻��ȷ!";
					java.text.SimpleDateFormat formatDate = new java.text.SimpleDateFormat(
							"yyyy-MM-DD");
					birthday = formatDate.parse(strBirthday);
				}
				catch (Exception e)
				{
					errorMsg = "�����������벻��ȷ!";
				}
			}
			if (errorMsg.equals(""))
				out.println("��֤�ɹ�!");
			else
				out.println(errorMsg);

		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}
	}

}
