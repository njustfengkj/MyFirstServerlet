package chapter15.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class AjaxAction extends ActionSupport
{
	private String city;

	// city���Ե�getter����
	public String getCity()
	{
		return city;
	}

	// city���Ե�setter����
	public void setCity(String city)
	{
		this.city = city;
	}

	public String execute() throws Exception
	{

		if (city != null)
			city = new String(city.getBytes("ISO-8859-1"), "UTF-8");
		return SUCCESS;
	}

}