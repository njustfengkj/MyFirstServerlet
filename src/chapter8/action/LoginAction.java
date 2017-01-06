package chapter8.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class LoginAction implements Action
{
	// ��װ���������username����
	private String username;
	// ��װ���������password����
	private String password;

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
			// ���ActionContext����,����ͨ���ö���ʵ������Servlet API
			ActionContext ctx = ActionContext.getContext();
			// ���Map���󣬿��������Map�������ServletContext����
			Map application = ctx.getApplication();
			// ���Map���󣬿��������Map�������HttpSession����
			Map session = ctx.getSession();
			// ��ServletContext�����л�ü���������
			Integer counter = (Integer) application.get("counter");
			// ����������Ϊnull�������ʼ��Ϊ1

			session.put("username", getUsername());// ���û���������HttpSession������
			String pw = users.get(username);// �����û��Ƿ����
			// δ�ҵ��û����û������ڣ���¼ʧ��
			if (pw == null)
			{
				ctx.put("info", "���û������ڣ���¼ʧ��!");// ��������������HttpServletRequest������
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
					ctx.put("info", "�ѳɹ���¼!");
					return SUCCESS;
				}
				else
				{
					ctx.put("info", "������󣬵�¼ʧ��!");// ��������������HttpServletRequest������
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