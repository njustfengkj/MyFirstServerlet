package chapter14.action;

import com.opensymphony.xwork2.*;
import org.apache.struts2.util.IteratorGenerator.Converter;

public class GeneratorAction extends ActionSupport
{
	private String str;

	static class StringObject
	{
		private String s;

		public StringObject(String s)
		{
			this.s = s;
		}
		public String getStr()
		{
			return "StringObject��" + s;
		}
	}

	public String getStr()
	{
		return str;
	}

	public void setStr(String str)
	{
		this.str = str;
	}

	public String execute() throws Exception
	{
		str = "Windows������ϵͳ��;Office���칫�����;Visual Studio���������ߣ�;Java��������ԣ�";

		return SUCCESS;
	}

	public Converter getMyConverter()
	{
		return new Converter()
		{
			public Object convert(String value) throws Exception
			{
				return new StringObject(value);
			}
		};
	}
}