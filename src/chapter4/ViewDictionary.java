package chapter4;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewDictionary extends HttpServlet
{

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		try
		{
			javax.naming.Context ctx = new javax.naming.InitialContext();
			// ����webdb����Դ���DataSource����
			javax.sql.DataSource ds = (javax.sql.DataSource) ctx
					.lookup("java:/comp/env/jdbc/webdb");
			Connection conn = ds.getConnection();
			// ִ��SQL���
			PreparedStatement pstmt = conn
					.prepareStatement("SELECT * FROM t_dictionary");
			ResultSet rs = pstmt.executeQuery();
			StringBuilder table = new StringBuilder();
			table.append("<table border='1'>");
			table.append("<tr><td>����</td><td>�۸�</td></tr>");
			while (rs.next()) // ���ɲ�ѯ���
			{
				table.append("<tr><td>" + rs.getString("english") + "</td><td>");
				table.append(rs.getString("chinese") + "</td></tr>");
			}
			table.append("</table>");
			out.println(table.toString()); // �����ѯ���

			pstmt.close();  // �ر�PreparedStatement����
		}
		catch (Exception e)
		{
			out.println(e.getMessage());
		}
	}

}
