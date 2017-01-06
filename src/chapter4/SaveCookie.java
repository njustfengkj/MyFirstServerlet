package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SaveCookie extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// ������ʱCookie����ʱCookie��������path����
		Cookie tempCookie = new Cookie("temp", "87654321"); // ��ʱCookie
		tempCookie.setMaxAge(-1); // -1��MaxAge��Ĭ��ֵ
		response.addCookie(tempCookie);
		// ����MaxAgeΪ0��Cookie
		Cookie cookie = new Cookie("cookie", "6666");
		cookie.setMaxAge(0); // MaxAge��Ϊ0����������յ�Cookie��Cookie������ɾ��
		response.addCookie(cookie);
		// ��������Cookie
		String user = request.getParameter("user");
		if (user != null) // �������url����user�����������������Cookie
		{
			Cookie userCookie = new Cookie("user", user);
			userCookie.setMaxAge(60 * 60 * 24); // ��MaxAge��Ϊ1��
			userCookie.setPath("/"); // ���Cookie��վ��������Ŀ¼�µķ���·������Ч
			response.addCookie(userCookie);
		}
		RequestDispatcher readCookie = getServletContext() // ����/servlet/ReadCookie��Դ
				.getRequestDispatcher("/servlet/ReadCookie");
		readCookie.include(request, response);

	}

}
