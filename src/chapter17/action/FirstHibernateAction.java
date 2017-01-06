package chapter17.action;

import hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import chapter17.entity.*;

public class FirstHibernateAction extends ActionSupport implements
		ModelDriven<MyMessage>
{
	private MyMessage myMessage = new MyMessage();
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

	public MyMessage getModel()
	{
		return myMessage;
	}

	public String execute() throws Exception
	{

		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		try
		{
			tx = session.beginTransaction(); // ��ʼ����
			session.save(myMessage); // ��������
			tx.commit();
			setResult("�ɹ���Ӽ�¼!");
		}
		catch (Exception e)
		{
			setResult(e.getMessage());
			tx.rollback();
		}

		finally
		{
			session.close(); // �ر�Session����
		}

		return SUCCESS;
	}

}