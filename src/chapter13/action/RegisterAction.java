package chapter13.action;

import chapter13.*;

import com.opensymphony.xwork2.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterAction extends MyActionSupport 
{
	private String username;
	private String password;
	private int age;
	private java.util.Date birthday;
    private String result;
    private String time;
	// time���Ե�getter����
	public String getTime()
	{
		return time;
	}

	// time���Ե�setter����
	public void setTime(String time)
	{
		this.time = time;
	}

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
	public java.util.Date getBirthday()
	{
		return birthday;
	}

	// birthday���Ե�setter����
	public void setBirthday(java.util.Date birthday)
	{
		this.birthday = birthday;
	}

	public String execute() throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		setTime( dateFormat.format(new Date()));		
	
		if(getUsername().length() <4)
		{
			//setResult(getText("failResult", new String[]{username}));
			setResult(getText("failResult"));
			return ERROR;
		}
		//setResult(getText("successResult", new String[]{username}));
		setResult(getText("successResult"));
		
		return SUCCESS; 
	}

}