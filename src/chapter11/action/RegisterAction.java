package chapter11.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class RegisterAction extends ActionSupport
{
	private String username;
	private String password;
	private int age;
	private Date birthday;
	private String result;

	// result���Ե�getter����
	public String getResult()
	{
		return result;
	}

	// result���Ե�setter����
	public void setResult(String result)
	{
		this.result = result;
	}

	// username���Ե�getter����
	public String getUsername()
	{
		return username;
	}

	// username���Ե�setter����
	public void setUsername(String username)
	{
		this.username = username;
	}

	// password���Ե�getter����
	public String getPassword()
	{
		return password;
	}

	// password���Ե�setter����
	public void setPassword(String password)
	{
		this.password = password;
	}

	// age���Ե�getter����
	public int getAge()
	{
		return age;
	}

	// age���Ե�setter����
	public void setAge(int age)
	{
		this.age = age;
	}

	// birthday���Ե�getter����
	public Date getBirthday()
	{
		return birthday;
	}

	// birthday���Ե�setter����
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

	public String execute() throws Exception
	{
		setResult("ע��ɹ�!");
		return SUCCESS;
	}

	public String register() throws Exception
	{
		setResult("ע��ɹ�����register��������!");
		return SUCCESS;
	}

	public void validateRegister1()
	{

		if (username == null || username.equals("")
				|| !username.matches("^\\w*$") || username.length() <= 4
				|| username.length() >= 20)
		{
			addFieldError("username",
					"validateRegister����Ч�飬�û�����������ĸ������,�ҳ��ȱ������4��20֮��!");
		}
		if (password == null || password.equals("") || password.length() < 8
				|| password.length() > 30)
		{
			addFieldError("password", "validateRegister����Ч�飬����ĳ��ȱ������8��30֮��!");
		}
		if (age <= 0 && age <= 200)
		{
			addFieldError("age", "validateRegister����Ч�飬����������һ����Ч������!");
		}

		if (birthday == null)
		{
			addFieldError("birthday", "validateRegister����Ч�飬�������ڱ������룡");
		}
		else
		{
			Calendar endDate = Calendar.getInstance();
			Calendar startDate = Calendar.getInstance();
			startDate.set(1900, 1, 1);
			if (birthday.after(endDate.getTime())
					|| birthday.before(startDate.getTime()))
			{
				addFieldError("birthday",
						"validateRegister����Ч�飬�������ڱ�����һ����Ч��Χ�ڣ�");
			}

		}

	}

	public void validate1()
	{

		if (username == null || username.equals("")
				|| !username.matches("^\\w*$") || username.length() < 4
				|| username.length() > 20)
		{
			addFieldError("username", "�û�����������ĸ������,�ҳ��ȱ������4��20֮��!");
		}
		if (password == null || password.equals("") || password.length() < 8
				|| password.length() > 30)
		{
			addFieldError("password", "����ĳ��ȱ������8��30֮��!");
		}
		if (age <= 0 && age <= 200)
		{
			addFieldError("age", "����������һ����Ч������!");
		}
		if (birthday == null)
		{
			addFieldError("birthday", "�������ڱ������룡");
		}
		else
		{

			Calendar endDate = Calendar.getInstance();
			Calendar startDate = Calendar.getInstance();

			startDate.set(1900, 1, 1);
			if (birthday.after(endDate.getTime())
					|| birthday.before(startDate.getTime()))
			{
				addFieldError("birthday", "�������ڱ�����һ����Ч��Χ�ڣ�");
			}
		}

	}
}