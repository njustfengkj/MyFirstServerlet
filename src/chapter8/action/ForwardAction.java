package chapter8.action;

import com.opensymphony.xwork2.*;

public class ForwardAction implements Action
{
	private String forward;
	// forward���Ե�getter����
	public String getForward()
	{
		return forward;
	}
	// forward���Ե�setter����
	public void setForward(String forward)
	{
		this.forward = forward;
	}
	public String execute() throws Exception
	{		
		return SUCCESS;
	}

}