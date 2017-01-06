package chapter12.action;

import com.opensymphony.xwork2.*;
import java.io.*;

public class UploadAction extends ActionSupport
{
	// ��װ�ϴ��ļ��������
	private File upload;
	// ��װ�ϴ��ļ����͵�����
	private String uploadContentType;
	// ��װ�ϴ��ļ���������
	private String uploadFileName;
	// ��װ�ϴ��ļ����ļ���������
	private String filename;
	// ��װ�ϴ��ļ������ڷ�������·����ͨ����������
	private String uploadPath;
	// ��װ�ϴ��ļ����͵����ԣ�ͨ����������
	private String allowTypes;

	// ��װ������������
	private String result;

	// result���Ե�getter����
	public String getResult()
	{
		return result;
	}

	// result���Ե�setter����
	public void setResult(String result)
	{
		this.result = result;
	}

	// upload���Ե�getter����
	public File getUpload()
	{
		return upload;
	}

	// upload���Ե�setter����
	public void setUpload(File upload)
	{
		this.upload = upload;
	}

	// uploadContentType���Ե�getter����
	public String getUploadContentType()
	{
		return uploadContentType;
	}

	// uploadContentType���Ե�setter����
	public void setUploadContentType(String uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	// uploadFileName���Ե�getter����
	public String getUploadFileName()
	{
		return uploadFileName;
	}

	// uploadFileName���Ե�setter����
	public void setUploadFileName(String uploadFileName)
	{
		this.uploadFileName = uploadFileName;
	}

	// filename���Ե�getter����
	public String getFilename()
	{
		return filename;
	}

	// filename���Ե�setter����
	public void setFilename(String filename)
	{
		this.filename = filename;
	}

	// uploadPath���Ե�getter����
	public String getUploadPath()
	{
		return uploadPath;
	}

	// uploadPath���Ե�setter����
	public void setUploadPath(String uploadPath)
	{
		this.uploadPath = uploadPath;
	}

	private boolean allowType(String contentType)
	{
		String[] types = allowTypes.split(",");
		for (String type : types)
		{
			if (contentType.equals(type.trim()))
				return true;
		}
		return false;
	}

	public String execute() throws Exception
	{
		//if (!allowType(uploadContentType))
		if (false)
		{
			result = "�������ϴ������͵��ļ���";
		}
		else
		{
			String fn = "";
			if (filename.equals(""))
			{
				// ����ϴ��ļ���
				fn = uploadPath
						+ uploadFileName;
			}
			else
			{
				fn = uploadPath + filename;
			}
			if (new File(fn).exists())
			{
				result = "���ļ��Ѿ����ڣ���Ϊ�ļ�ָ��һ���µ��ļ�����";
			}
			else
			{
				FileOutputStream fos = new FileOutputStream(fn);
				InputStream is = new FileInputStream(upload);
				byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�
				int count = 0;
				while ((count = is.read(buffer)) > 0)
				{
					fos.write(buffer, 0, count);
				}
				fos.close();
				is.close();
				result = "�ļ��ϴ��ɹ���";
			}
		}
		return "result";
	}

	// uploadTypes���Ե�getter����
	public String getAllowTypes()
	{
		return allowTypes;
	}

	// uploadTypes���Ե�setter����
	public void setAllowTypes(String allowTypes)
	{
		this.allowTypes = allowTypes;
	}
}