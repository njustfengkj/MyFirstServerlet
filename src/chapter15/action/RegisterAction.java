package chapter15.action;

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



}