package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Helloworld extends HttpServlet // Servlet������HttpServlet��������̳�
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html"); // ����HTTP��Ӧͷ��Content-Type�ֶ�ֵ		
		PrintWriter out = response.getWriter(); // ������������Ϣ��PrintWriter����
		out.println("<b>Hello world</b>"); // ��ͻ������Hello world
	}
}
