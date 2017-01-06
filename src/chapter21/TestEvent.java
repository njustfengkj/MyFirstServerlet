package chapter21;

import hibernate.*;
import org.hibernate.*;
import chapter17.entity.*;
import java.util.*;


public class TestEvent
{

	public static void main(String[] args)
	{

		Session session = HibernateSessionFactory.getSession();

		Transaction tx = session.beginTransaction();
		MyMessage message = new MyMessage();
		message.setId(new Random().nextInt(100000));
		message.setName("bill");  
		session.saveOrUpdate(message);  // ���ܳ־û�
		MyMessage message1 = new MyMessage();
		message1.setId(new Random().nextInt(100000));
		message1.setName("bill gates");
		session.saveOrUpdate(message1);  // �ɹ��־û�
		tx.commit();

		session.close();

	}
}
