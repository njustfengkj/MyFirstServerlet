package chapter16.dao;


public class DAOSupport
{
	// �����������ݿ��Connection����
	protected java.sql.Connection conn = null;

	// ִ�и���SQL���ķ���
	protected java.sql.ResultSet execSQL(String sql, Object... args)
			throws Exception
	{
		//  �����ݿ�����
		openConnection();
		// ����PreparedStatement����
		java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);
		// ΪpStmt��������SQL����ֵ
		for (int i = 0; i < args.length; i++)
		{
			pStmt.setObject(i + 1, args[i]);
		}

		pStmt.execute();// ִ��SQL���
		return pStmt.getResultSet(); // ���ؽ���������ִ�е�SQL��䲻���ؽ�������򷵻�null
	}

	private void openConnection()
	{
		try
		{
			// ���connΪnull�������ݿ�����
			if (conn == null)
			{
				javax.naming.Context ctx = new javax.naming.InitialContext();
				// ��ȡ����Դ
				javax.sql.DataSource ds = (javax.sql.DataSource) ctx
						.lookup("java:/comp/env/jdbc/webdb");
				conn = ds.getConnection(); // ����һ��Connection����
			}
		}
		catch (Exception e)
		{
		}
	}

	public void close()
	{
		try
		{
			// ������ݿ����������򿪣��ر���
			if (conn != null)
				conn.close();
		}
		catch (Exception e)
		{

		}
	}
}
