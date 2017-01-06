package chapter8.action.wildcard;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;
import java.util.*;

import javax.servlet.http.*;

public class LoginRegisterAction extends ActionSupport implements ServletRequestAware
{
	// ��װ���������username����
	private String username;
	// ��װ���������password����
	private String password;

	private HttpServletRequest request;


	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;		
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

	public String register() throws Exception
	{
		request.setAttribute("info", "���Ѿ�ע��ɹ�");
		return SUCCESS;
	}

	public String login() throws Exception
	{
		try
		{
			if (getUsername().equals("bill") && getPassword().equals("1234"))
			{
				request.setAttribute("info", "��¼�ɹ�");
				return SUCCESS;
			}
			else
			{
				request.setAttribute("info", "��¼ʧ��");
				return ERROR;
			}		
		}
		catch (Exception e)
		{
			return ERROR;
		}
	}

}