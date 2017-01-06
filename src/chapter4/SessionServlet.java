package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class SessionServlet extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60 * 60 * 24); // ����Session�ĳ�ʱ���Ϊ1��
		if (session.isNew()) // ������½����ĻỰ����������ֵ
		{
			session.setAttribute("session", "����");
			out.println("�»Ự�Ѿ�������");
		}
		else
			// �������ǰ�����ĻỰ������������ֵ
			out.println("�Ự����ֵ��" + session.getAttribute("session"));
	}

}
