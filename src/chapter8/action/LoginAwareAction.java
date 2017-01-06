package chapter8.action;

import com.opensymphony.xwork2.*;
import org.apache.struts2.interceptor.*;
import java.util.*;

import javax.servlet.http.*;

public class LoginAwareAction implements Action, ServletRequestAware,
		ApplicationAware
{


	// ��װ���������username����
	private String username;
	// ��װ���������password����
	private String password;

	private HttpServletRequest request;
	private Map application;

	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;

	}

	public void setApplication(Map application)
	{
		this.application = application;


	}

	// �����û���Ϣ��Map����
	private static Map<String, String> users = new java.util.HashMap<String, String>();

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

	static
	{
		users.put("bill", "1234");
		users.put("mike", "4321");
	}

	public String execute() throws Exception
	{
		try
		{

			HttpSession session = request.getSession();
			// ��ServletContext�����л�ü���������
			Integer counter = (Integer) application.get("counter");
			// ����������Ϊnull�������ʼ��Ϊ1

			session.setAttribute("username", getUsername());// ���û���������HttpSession������
			String pw = users.get(username);// �����û��Ƿ����
			// δ�ҵ��û����û������ڣ���¼ʧ��
			if (pw == null)
			{
				request.setAttribute("info", "���û������ڣ���¼ʧ��!");// ��������������HttpServletRequest������
				return ERROR;
			}
			else
			{

				if (pw.equals(getPassword()))
				{
					if (counter == null)
					{
						counter = 1;
					}
					else
					{
						counter++;// ������������1
					}
					application.put("counter", counter);// ��������������ServletContext������
					request.setAttribute("info", "�ѳɹ���¼!");
					return SUCCESS;
				}
				else
				{
					request.setAttribute("info", "������󣬵�¼ʧ��!");// ��������������HttpServletRequest������
					return ERROR;
				}

			}
		}
		catch (Exception e)
		{
			return ERROR;
		}
	}

}