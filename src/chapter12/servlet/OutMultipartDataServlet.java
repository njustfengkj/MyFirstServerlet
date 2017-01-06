package chapter12.servlet;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OutMultipartDataServlet extends HttpServlet
{
	
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out  = response.getWriter();
		InputStream is = request.getInputStream();		
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String requestData = "";
		String s = "";
		java.util.Enumeration<String> headers = request.getHeaderNames();
		out.println("������Ϣͷ<br>");
		while(headers.hasMoreElements())
		{
			String header = headers.nextElement();
			out.println(header + ":" + request.getHeader(header) + "<br>");
		}
		out.println("<p/>");
		out.println("������Ϣ����<br>");
		while((s = br.readLine()) != null)
		{			
			requestData = requestData + s + "<br>";
		}
		out.println(requestData);
	}

}
