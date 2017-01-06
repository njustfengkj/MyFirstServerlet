package chapter19;

import hibernate.*;
import org.hibernate.*;
import chapter19.entity.*;

public class ManyToOne
{
	public static void main(String[] args)
	{
		Session session = HibernateSessionFactory.getSession();
		// �־û�order��customer����
		Transaction tx = session.beginTransaction();
        Customer customer = new Customer();
		customer.setName("Bea");
		Order order = new Order();
		
		order.setNumber("2008012401");
		order.setCustomer(customer);
		session.save(order);      
		tx.commit();
		int id = order.getId();  // ����Ѿ����־û���order�����idֵ
		
		// װ��order��customer����
	    // ��ʼһ��������
		tx = session.beginTransaction();
		order = (Order)session.get(Order.class, id);
		 
		if(order != null)
		{
			System.out.println("Customer��" + order.getCustomer().getName());
			System.out.println("Order Number��" + order.getNumber());
		}		
		tx.commit();
		session.close();		
	}
}
