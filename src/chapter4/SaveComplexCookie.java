package chapter4;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class SaveComplexCookie extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		// ����һ�����ڽ���Base64�����BASE64Encoder����
		sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
		// ����һ�����ڽ��ձ����л��Ķ���ʵ���ֽ�����ByteArrayOutputStream����
		ByteArrayOutputStream classBytes = new ByteArrayOutputStream();
		// ����һ������������д������ObjectOutputStream����
		ObjectOutputStream oos = new ObjectOutputStream(classBytes);
		oos.writeObject(new MyCookie()); // д��MyCookie����ʵ��
		oos.close(); // �ر�ObjectOutputStream����
		// �������л��Ķ���ʵ�����ֽ�����Base64�����ʽ���б���
		String classStr = base64Encoder.encode(classBytes.toByteArray());
		Cookie cookie = new Cookie("mycookie", classStr); // ��Base64����д��Cookie
		cookie.setMaxAge(60 * 60 * 24); // Cookie�ĳ�ʱʱ��Ϊ1��
		response.addCookie(cookie);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("MyCookie�Ķ���ʵ����д��Cookie"); // �����ʾ��Ϣ
	}
}
