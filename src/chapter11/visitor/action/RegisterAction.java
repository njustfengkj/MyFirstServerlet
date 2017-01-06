package chapter11.visitor.action;

import com.opensymphony.xwork2.*;
import java.util.*;
import chapter11.visitor.*;

public class RegisterAction extends ActionSupport
{
	private User user = new User();
    private String result;

	// user���Ե�getter����
	public User getUser()
	{
		return user;
	}

	// user���Ե�setter����
	public void setUser(User user)
	{
		this.user = user;
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


	public String execute() throws Exception
	{
		System.out.println(user.getName());
		setResult("ע��ɹ�!");
		return SUCCESS;
	}

}