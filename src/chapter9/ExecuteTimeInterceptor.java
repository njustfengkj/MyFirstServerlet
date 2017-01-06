package chapter9;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.*;

//public class ExecuteTimeInterceptor extends AbstractInterceptor
public class ExecuteTimeInterceptor extends MethodFilterInterceptor
{
    private String name;
	
	// name���Ե�getter����
	public String getName()
	{
		return name;
	}

	// name���Ե�setter����
	public void setName(String name)
	{
		this.name = name;
	}

	@Override
	public String doIntercept(ActionInvocation invocation) throws Exception
	{		
		invocation.addPreResultListener(new MyPreResultListener());
		System.out.println(getName() + " ��ʼִ��");
		long start = System.currentTimeMillis();
		invocation.getStack().set("start", start);
		String result = invocation.invoke();
		long end = System.currentTimeMillis();
		System.out.println(getName() + " ִ��Action������ʱ�䣺" + (end - start) + "����");
		System.out.println(getName() + " ִ�н���");
		return result;
	}

}
