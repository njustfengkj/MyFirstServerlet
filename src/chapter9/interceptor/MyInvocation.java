package chapter9.interceptor;
import java.util.*;
public class MyInvocation
{
	//  ��������������
	private List<Interceptor> interceptors = new LinkedList<Interceptor>();	
	private Object action;//  �����صĶ���
	private int interceptorIndex = 0;//  �������ĵ�������
    //  ���췽��������ע����������Action����
	public MyInvocation(Object action, Interceptor... interceptors)
	{
		//  ������������ӵ�intercetors��
		for (int i = 0; i < interceptors.length; i++)
		{
			this.interceptors.add(interceptors[i]);
		}
		this.action = action;
	}
	//  ִ�е������е�������������execute����
	public void invoke() throws Exception
	{
        //  �������е�����������������ִ�����ˣ���ʼ����execute����
		if (interceptorIndex == interceptors.size())
		{
			try
			{
				//  ��Action������Ѱ��execute���������δ�ҵ������׳��쳣
				java.lang.reflect.Method method = action.getClass().getMethod(
						"execute");
				method.invoke(getAction());//  ����execute����
				
			}
			catch (Exception e)
			{
				throw new Exception("��action��δ����execute����!");
			}
			return;
		}
		//  ִ�е������е������������������������ĵ���������1
		interceptors.get(interceptorIndex++).intercept(this);
	}
    //  ���Action����
	public Object getAction()
	{
		return this.action;
	}
}
