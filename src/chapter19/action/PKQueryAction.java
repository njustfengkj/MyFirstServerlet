package chapter19.action;

import hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import chapter17.entity.*;
import chapter19.entity.*;

public class PKQueryAction extends ActionSupport
{
    private int id;
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
	public String execute() throws Exception
	{
		result = "ok";
		return SUCCESS;
	}
	public String singlepk() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();		
		Object obj = session.get(MyMessage.class, id);
		System.out.println(id);
		if(obj != null)
		{
			MyMessage myMessage = (MyMessage)obj;
			setResult("name����ֵ��" + myMessage.getName());
		}
		else
		{
			setResult("δ�����κμ�¼��");
		}
		session.close();		
		return SUCCESS;
	}

	// id���Ե�getter����
	public int getMyId()
	{
		return id;
	}

	// id���Ե�setter����
	public void setMyId(int id)
	{
		this.id = id;
	}

}