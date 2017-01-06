package chapter4;

import java.io.*;
import java.net.*;

public class ChineseRequestHeader
{
	public static void main(String[] args) throws Exception
	{
		String chineseUTF8 = "������Ϣ";
		String chineseURLEncode = java.net.URLEncoder.encode(chineseUTF8,
				"UTF-8");
		Socket socket = new Socket("localhost", 8080); // ��Socket�����ӷ�����
		OutputStream os = socket.getOutputStream(); // ���OutputStream����
		// ��UTF8�����ʽ����ChineseResponseHeader���ص���Ӧ��Ϣ
		java.io.OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
		// ��ʼ��ChineseResponseHeader����HTTP����ͷ��Ϣ
		osw.write("GET /webdemo/servlet/ChineseResponseHeader HTTP/1.1\r\n");
		osw.write("Host:localhost:8080\r\n");
		osw.write("chinese_utf8:" + chineseUTF8 + "\r\n"); // ����UTF8�����������Ϣ
		osw.write("chineseURLEncode:" + chineseURLEncode + "\r\n"); // ����URL�����������Ϣ
		osw.write("Connection:close\r\n\r\n");
		osw.flush(); // ˢ�»�����
		InputStream is = socket.getInputStream(); // ���InputStream����
		// ��UTF-8�����ʽ��ȡChineseResponseHeader���ص�HTTP��Ӧ��Ϣͷ
		InputStreamReader isr = new InputStreamReader(is, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		String s = "";
		// ��ʼ����Ϊ��λ��ȡ��Ӧ��Ϣ
		while ((s = br.readLine()) != null)
		{
			String strArray[] = s.split(":"); // ��������ʽ�����Ϣ�ֶΰ����Ϣ�ֶ�ֵ
			if (strArray.length == 2)
			{
				// ���ֶ�����chinese_utf8ʱ������ֶ������ֶ�ֵ
				if (strArray[0].trim().equals("chinese_utf8"))
				{
					System.out.println(s);
				}
				// ���ֶ�����chineseURLEncodeʱ������ֶ������ֶ�ֵ
				else if (strArray[0].trim().equals("chineseURLEncode"))
				{
					System.out.println(java.net.URLDecoder.decode(s, "UTF-8"));
				}
			}
		}
		is.close();
		osw.close();
	}
}
