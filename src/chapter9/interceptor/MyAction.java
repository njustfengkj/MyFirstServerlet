package chapter9.interceptor;

public class MyAction implements Property
{
	public String getValue()
	{
		return "����ֵ";
	}

	public void execute()
    {
    	System.out.println("execute");
    }
}
