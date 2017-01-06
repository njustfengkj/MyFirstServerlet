package chapter9;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.*;

public class MyPreResultListener  implements PreResultListener
{

	public void beforeResult(ActionInvocation invocation, String resultCode) 
	{
		System.out.println("execute�����ķ���ֵ��" + resultCode);
		long start = (Long)invocation.getStack().findValue("start");
		long end = System.currentTimeMillis();
		System.out.println("ִ��Action������ʱ�䣺" + (end - start) + "����");

		System.out.println("ִ�н���");

	}

}
