package chapter4;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ChineseResponseHeader extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String chineseUTF8 = request.getHeader("chinese_utf8"); // �����Ϣͷchinese_utf8��ֵ
		// �����ϢͷchineseURLEncode��ֵ
		String chineseURLEncode = request.getHeader("chineseURLEncode");
		// ȡ��UTF-8���룬�ٽ���ת����UCS2�����ʽ��������chineseUTF8��
		chineseUTF8 = new String(chineseUTF8.getBytes("iso-8859-1"), "utf-8");
		System.out.println(chineseUTF8); // �����̨���chineseUTF8��ֵ
		// ������Ӧ��Ϣͷchinese_utf8��ֵ����Ҫ��UTF-8����ֱ�ӷŵ�String������
		response.setHeader("chinese_utf8", new String(chineseUTF8
				.getBytes("UTF-8"), "ISO-8859-1")); // ������Ӧ��ϢͷchineseURLEncode��ֵ����%xx��ʽ�ı��밴ԭ������
		response.setHeader("chineseURLEncode", chineseURLEncode);
		// �Կͻ��˷�������%xx��ʽ��������Ϣ���н���
		chineseURLEncode = java.net.URLDecoder
				.decode(chineseURLEncode, "UTF-8");
		System.out.println(chineseURLEncode); // ���chineseURLEncode��ֵ
	}
}
