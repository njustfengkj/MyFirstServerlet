package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class OutChinese extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String s = "������Ϣ";
		/*response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(s);*/
		
		//out.println("������Ϣ");
		PrintWriter out = response.getWriter();
		response.setHeader("Content-Type", "text/html;charset=utf-8");
		out.println(new String(s.getBytes("utf-8"), "iso-8859-1"));
		
	   // out.println(java.net.URLEncoder.encode(s, "utf-8"));
		
		//����2
		//response.setHeader("Content-Type", "text/html;charset=gbk");
		// out.println(new String(s.getBytes("gbk"), "iso-8859-1"));
		
		// �൱��
		//out.println(new String(s.getBytes("iso-8859-1"), "iso-8859-1"));
		
	}
}
