package chapter20;

import hibernate.*;

import org.hibernate.*;

import chapter17.entity.*;

import java.util.*;

public class PessimisticLocking
{
	public static void main(String[] args) throws Exception
	{
		Session session = HibernateSessionFactory.getSession();			
		Transaction tx = session.beginTransaction();
		tx.begin();
		String hql = "from MyMessage as my where id = 1";		
		Query query = session.createQuery(hql);
		query.setLockMode("my", LockMode.UPGRADE);
		
		
		List<MyMessage> messages = query.list();
		for(MyMessage my: messages)
			System.out.println(my.getName());
		System.out.println("����id=1�ļ�¼���޷��޸ģ����س�����޸�");
		System.in.read();
		tx.commit();
		session.close();

	}

}
