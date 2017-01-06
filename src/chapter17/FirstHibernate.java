package chapter17;

import org.hibernate.*;
import hibernate.*;
import chapter17.entity.*;

public class FirstHibernate
{
	public static void main(String[] args) throws Exception
	{
		
		Session session = HibernateSessionFactory.getSession();
		Transaction tx = null;
		java.io.InputStreamReader isr = new java.io.InputStreamReader(System.in);
		java.io.BufferedReader br = new java.io.BufferedReader(isr);
		String s = "";
		System.out.print("������id��name���Զ��ŷָ�,����q�˳����򣩣�");
		while (!(s = br.readLine()).trim().equals(""))
		{
			if (s.equalsIgnoreCase("q"))
				break;
			String[] input = s.split(",");  // �ָ��ַ���
			if (input.length > 1)
			{
				try
				{
					int id = Integer.parseInt(input[0]);
					String name = input[1];
					MyMessage message = new MyMessage();
					message.setId(id);
					message.setName(name);
					try
					{
						tx = session.beginTransaction();  // ��ʼ����
						session.save(message);  // ��������
						tx.commit();
						System.out.println("����ɹ�!");
					}
					catch (Exception e)
					{
						
						System.out.println(e.getMessage());
					}
				}
				catch (Exception e)
				{
					System.out.println(e.getMessage());
				}
			}
			System.out.print("������id��name���Զ��ŷָ�,����q�˳����򣩣�");
		}
		session.close();  // �ر�Session����
	}
}
