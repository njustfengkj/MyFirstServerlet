package chapter25;

import org.springframework.jdbc.core.JdbcTemplate;

public class MessageImpl implements Message
{
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public void process()
	{
		jdbcTemplate.update("delete from t_message");
		//int i = 1/0; // ���׳�һ��java.lang.ArithmeticException�쳣
		jdbcTemplate.update("insert into t_message(id, name) values(1, '��Ϣ1')");
		/*try
		{
			Thread.sleep(70000); 
		}
		catch (Exception e)
		{
			
		}*/
		jdbcTemplate.update("insert into t_message(id, name) values(2, '��Ϣ2')");
	}
}
