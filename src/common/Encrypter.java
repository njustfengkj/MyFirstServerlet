package common;

import java.security.*;

public class Encrypter
{
	// ��MD5�㷨�����ַ���
	public static String md5Encrypt(String s) throws Exception
	{
		//  ���֧��MD5�㷨��MessageDigest
		MessageDigest md5 = MessageDigest.getInstance("MD5");
        //  ���BASE64Encoder������Base64��ʽ���ַ������б���
		sun.misc.BASE64Encoder base64Encoder = new sun.misc.BASE64Encoder();
		// ���ַ������м��ܣ��������ܺ���ַ�����Base64��ʽ���б��룬�����������		
		return base64Encoder.encode(md5.digest(s.getBytes("utf-8")));
	}

}
