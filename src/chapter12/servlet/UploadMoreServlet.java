package chapter12.servlet;

import java.io.*;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadMoreServlet extends HttpServlet
{

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{
		try
		{
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			FileItemFactory factory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(factory);
			List<FileItem> items = upload.parseRequest(request);
			String uploadPath = this.getInitParameter("path");
			String filename = "";

			for (FileItem item : items) // ѭ�������ϴ��ļ�
			{
				if (!item.isFormField())
				{
					filename = item.getName();
					if (filename.equals(""))
						continue;
					filename = uploadPath + System.currentTimeMillis()
							+ filename.substring(filename.lastIndexOf("."));
					FileOutputStream fos = new FileOutputStream(filename);
					if (item.isInMemory())
					{
						fos.write(item.get());

					}
					else
					{
						InputStream is = item.getInputStream();
						byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�
						int count = 0;
						while ((count = is.read(buffer)) > 0)
						{
							fos.write(buffer, 0, count);
						}

						is.close();

					}
					fos.close();
				}
			}
			out.println("�ļ��ϴ��ɹ�!");
		}
		catch (Exception e)
		{
			System.err.println(e.getMessage());
		}

	}

}
