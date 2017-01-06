package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ReadCookie extends HttpServlet
{

	// ͨ��һ��Cookie�����Cookie����δ�ҵ�ָ������Cookie���󣬷���null
	protected Cookie getCookieValue(Cookie[] cookies, String name)
	{
		if (cookies != null)
		{
			for (Cookie c : cookies)
			{
				if (c.getName().equals(name))
					return c;
			}
		}
		return null;
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		// �����ʱCookie ��getCookies�������һ��������������Ϣͷ������Cookie������
		Cookie tempCookie = getCookieValue(request.getCookies(), "temp");
		if (tempCookie != null)
			out.println("��ʱCookieֵ��" + tempCookie.getValue() + "<br/>");
		else
			out.println("��ʱCookieδ���ã�<br/>");
		// ���Cookie��Զ�����ܻ�ã���Ϊ����MaxAgeΪ0
		Cookie cookie = getCookieValue(request.getCookies(), "cookie");
		if (cookie != null)
			out.println("cookie��" + cookie.getValue() + "<br/>");
		else
			out.println("cookie�Ѿ���ɾ��!<br/>");
		// �������Cookie
		Cookie userCookie = getCookieValue(request.getCookies(), "user");
		if (userCookie != null)
			out.println("user��" + userCookie.getValue());
		else
			out.println("userδ���ã�");
	}

}
