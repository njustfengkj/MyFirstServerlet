package chapter16.action;

import com.opensymphony.xwork2.*;
import chapter16.model.*;
import chapter16.dao.interfaces.*;
import chapter16.dao.*;

public class RegisterAction extends ActionSupport implements ModelDriven<User>
		
{
	private User user = new User();
	private String result;


	public User getModel()
	{
		return user;
	}

	public String execute() throws Exception
	{
		
		UserDAO userDAO = new UserDAOImpl();
		Object obj = ActionContext.getContext().getSession().get(
				"validation_code");
		String validationCode = (obj != null) ? obj.toString() : "";

		if (!validationCode.equalsIgnoreCase(user.getValidationCode()))
		{
			if (user.getValidationCode() != null)
			{
				this.addActionError("��֤���������!");
			}
			return INPUT;
		}
		
		try
		{
			userDAO.addUser(user);
		}
		catch (Exception e)
		{
			this.addActionError(e.getMessage());
			return INPUT;
		}
		result = "�û�<" + user.getUsername() + ">ע��ɹ�!";
		return SUCCESS;
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

}