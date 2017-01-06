package chapter8.modeldriven;
import com.opensymphony.xwork2.*;

public class LoginAction extends ActionSupport implements ModelDriven<UserLogin>
{

	private UserLogin model = new UserLogin();
	
	public UserLogin getModel()
	{		
		return model;
	}

	@Override
	public String execute() throws Exception
	{
		//Thread.sleep(5000);
		if(getModel().getUsername().equals("bill") && getModel().getPassword().equals("1234"))
		{
			getModel().setResult("��¼�ɹ������ڽ����ˣ�");
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}		
	}

}
