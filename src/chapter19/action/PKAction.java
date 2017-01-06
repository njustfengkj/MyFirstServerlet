package chapter19.action;

import hibernate.HibernateSessionFactory;
import com.opensymphony.xwork2.*;
import org.hibernate.Session;
import org.hibernate.Transaction;
import chapter17.entity.*;
import chapter19.entity.*;

public class PKAction extends ActionSupport
{
    private int id;
    private String name;
    private int key1;
    private String key2;
    private String data;
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
	public String querypk() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();		
		Object obj = session.get(MyMessage.class, id);
		if(obj != null)
		{
			MyMessage myMessage = (MyMessage)obj;						
			setResult("��ѯ��id=" + id + "��name=" + myMessage.getName());			
		}
		else
		{
			setResult("��t_message����δ�ҵ��κμ�¼��");
		}
		
		session.close();		
		return SUCCESS;
	}
	public String queryCompositePK() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		PrimaryKey pk = new PrimaryKey();
		pk.setKey1(key1);
		pk.setKey2(key2);
		Object obj = session.get(Keys.class, pk);
		if(obj != null)
		{
			Keys keys = (Keys)obj;						
			setResult("��ѯ��key1=" + key1 + "��key2=" + key2 + ", data=" + keys.getData());			
		}
		else
		{
			setResult("��t_keys����δ�鵽�κμ�¼��");
		}
		
		session.close();		
		return SUCCESS;
	}

	public String updatepk() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		MyMessage myMessage = new MyMessage();
		myMessage.setId(id);
		myMessage.setName(name);
        session.saveOrUpdate(myMessage);						
		setResult("���棺id=" + id + "��name=" + myMessage.getName());			
	    tx.commit();
		session.close();		
		return SUCCESS;
	}
	public String updateCompositePK() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = session.beginTransaction();
		PrimaryKey pk = new PrimaryKey();
		pk.setKey1(key1);
		pk.setKey2(key2);
		Keys keys = new Keys();
		keys.setPrimaryKey(pk);
		keys.setData(data);
		session.saveOrUpdate(keys);						
		setResult("���棺key1=" + key1 + "��key2=" + key2 + ", data=" + keys.getData());			
	    tx.commit();
		session.close();		
		return SUCCESS;
	}
	
	// id���Ե�getter����
	public int getId()
	{
		return id;
	}

	// id���Ե�setter����
	public void setId(int id)
	{
		this.id = id;
	}

	// name���Ե�getter����
	public String getName()
	{
		return name;
	}

	// name���Ե�setter����
	public void setName(String name)
	{
		this.name = name;
	}

	// key1���Ե�getter����
	public int getKey1()
	{
		return key1;
	}

	// key1���Ե�setter����
	public void setKey1(int key1)
	{
		this.key1 = key1;
	}

	// key2���Ե�getter����
	public String getKey2()
	{
		return key2;
	}

	// key2���Ե�setter����
	public void setKey2(String key2)
	{
		this.key2 = key2;
	}

	// data���Ե�getter����
	public String getData()
	{
		return data;
	}

	// data���Ե�setter����
	public void setData(String data)
	{
		this.data = data;
	}

}