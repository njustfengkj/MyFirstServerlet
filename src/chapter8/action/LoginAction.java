package chapter8.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class LoginAction implements Action
{
	// 封装请求参数的username属性
	private String username;
	// 封装请求参数的password属性
	private String password;

	// 保存用户信息的Map对象
	private static Map<String, String> users = new java.util.HashMap<String, String>();

	// username属性的getter方法
	public String getUsername()
	{
		return username;
	}

	// username属性的setter方法
	public void setUsername(String username)
	{
		this.username = username;
	}

	// password属性的getter方法
	public String getPassword()
	{
		return password;
	}

	// password属性的setter方法
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
			// 获得ActionContext对象,可以通过该对象实例访问Servlet API
			ActionContext ctx = ActionContext.getContext();
			// 获得Map对象，可以用这个Map对象访问ServletContext对象
			Map application = ctx.getApplication();
			// 获得Map对象，可以用这个Map对象访问HttpSession对象
			Map session = ctx.getSession();
			// 从ServletContext对象中获得计数器变量
			Integer counter = (Integer) application.get("counter");
			// 计数器变量为null，将其初始化为1

			session.put("username", getUsername());// 将用户名保存在HttpSession对象中
			String pw = users.get(username);// 查找用户是否存在
			// 未找到用户，用户不存在，登录失败
			if (pw == null)
			{
				ctx.put("info", "该用户不存在，登录失败!");// 将处理结果保存在HttpServletRequest对象中
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
						counter++;// 计数器变量加1
					}
					application.put("counter", counter);// 将计数器保存在ServletContext对象中
					ctx.put("info", "已成功登录!");
					return SUCCESS;
				}
				else
				{
					ctx.put("info", "密码错误，登录失败!");// 将处理结果保存在HttpServletRequest对象中
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