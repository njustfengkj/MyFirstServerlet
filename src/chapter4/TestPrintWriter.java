package chapter4;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestPrintWriter extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		//response.setContentType("text/html; charset=utf-8");
		response.setHeader("myhead1", "value1");
		PrintWriter out = response.getWriter();
		response.setContentType("text/html; charset=utf-8");
		response.setHeader("Content-Type","text/html; charset=utf-8");
		// ������䲻��д�����λ�ã�����HTTP��Ӧ��Ϣͷ�����ڵ���getWriter����֮ǰ����
		// response.setContentType("text/html; charset=utf-8");
		response.setHeader("myhead2", "value2");
		out.println("<b>��Ӧ��Ϣ</b>");
	}

}
