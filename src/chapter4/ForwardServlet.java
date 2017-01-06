package chapter4;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ForwardServlet extends HttpServlet
{

	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// RequestDispatcher�����װ����Դ·��ǰ����ӡ�/��
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/servlet/IncludingServlet");
		rd.forward(request, response);

	}

}
