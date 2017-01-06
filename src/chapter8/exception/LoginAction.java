package chapter8.exception;
import com.opensymphony.xwork2.*;

public class LoginAction implements Action
{
	// ��װ���������username����
	private String username;
	// ��װ���������password����
	private String password;
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

	public String execute() throws Exception
	{		
		if(getUsername().equals("bill") && getPassword().equals("1234"))
		{			
			setResult("��¼�ɹ�������������");
			return SUCCESS;
		}
		else if(getUsername().equals("user"))
		{
			throw new UserException("�û�������Ϊuser���׳��û��쳣");
		}
		else if(getUsername().equals("sql"))
		{
			throw new java.sql.SQLException("�û�������sql���׳�SQL�쳣");
		}
		else
		{
			return ERROR;
		}				
	}

}