package chapter24;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import chapter17.entity.*;

public class ReadingData
{

	public static void main(String[] args)
	{
		ApplicationContext context = new FileSystemXmlApplicationContext(
				new String[]
				{ "src\\MyDataSource.xml", "src\\jdbctemplate.xml" });

		JdbcTemplate jdbcTemplate = (JdbcTemplate) context
				.getBean("jdbcTemplate");

		QueryMessage queryMessage = new QueryMessage(jdbcTemplate);

		// ��ѯһ����¼
		MyMessage message = queryMessage.getMessage(1);
		if (message != null)
		{
			System.out.println(message.getId());
			System.out.println(message.getName());
		}

		message = queryMessage.getOneMessage(2);
		if (message != null)
		{
			System.out.println(message.getId());
			System.out.println(message.getName());
		}

		// ��ѯ������¼
		java.util.List<MyMessage> messages = queryMessage.getAllMessages();
		for (MyMessage msg : messages)
		{
			System.out.println(msg.getId());
			System.out.println(msg.getName());
		}

		// ���ص�ֵ
		System.out.println("t_message�ļ�¼��:" + queryMessage.getRecordCount());
		String name = queryMessage.getName(3);
		if (name != null)
			System.out.println("id = 3, name=" + name);

		java.util.Map<String, Object> row = queryMessage.getSingleRow(4);
		if (row != null)
		{
			System.out.println(row.get("id"));
			System.out.println(row.get("name"));
		}
		
		

	}
}
