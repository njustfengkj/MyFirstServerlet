package chapter6;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class DBServlet extends HttpServlet
{
	//  �����������ݿ��Connection����
	protected java.sql.Connection conn = null;

	//  ִ�и���SQL���ķ���
	protected java.sql.ResultSet execSQL(String sql, Object... args)
			throws Exception
	{
		//  ����PreparedStatement����
		java.sql.PreparedStatement pStmt = conn.prepareStatement(sql);
		//  ΪpStmt��������SQL����ֵ
		for (int i = 0; i < args.length; i++)
		{
			pStmt.setObject(i + 1, args[i]);
		}
	
		pStmt.execute();//  ִ��SQL���
		return pStmt.getResultSet();  // ���ؽ���������ִ�е�SQL��䲻���ؽ�������򷵻�null
	}
    //  �˶��û��������֤���Ƿ�Ϸ�
	protected boolean checkValidationCode(HttpServletRequest request, String validationCode)
	{
		//  ��HttpSession�����л��ϵͳ������ɵ���֤��
		String validationCodeSession = (String)request.getSession().getAttribute("validation_code");
		
		//  �����õ���֤��Ϊnull��˵����֤����ڣ��û�����ˢ�¿ͻ���ҳ�棬�����»���µ���֤��
		if(validationCodeSession == null)
		{			
			request.setAttribute("info", "��֤�����");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�����");//  ����login.jsp��Ҫ�Ҵ�����Ϣ	
			return false;
		}
		//  ���û��������֤���ϵͳ������ɵ���֤����бȽ�
		if(!validationCode.equalsIgnoreCase(validationCodeSession))
		{
			request.setAttribute("info", "��֤�벻��ȷ");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�벻��ȷ");//  ����login.jsp��Ҫ�Ҵ�����Ϣ
			return false;
		}
		return true;
	}
	@Override
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			//  ���connΪnull�������ݿ�����
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

	@Override
	public void destroy()
	{
		try
		{
			//  ������ݿ����������򿪣��ر���
			if (conn != null)
				conn.close();
		}
		catch (Exception e)
		{

		}
	}

}
