package chapter12.action.array;

import com.opensymphony.xwork2.*;
import java.io.*;

public class UploadMoreAction extends ActionSupport
{
	// ��װ�ϴ��ļ��������
	private File[] upload;
	// ��װ�ϴ��ļ����͵�����
	private String[] uploadContentType;
	// ��װ�ϴ��ļ���������
	private String[] uploadFileName;

	
	// ��װ�ϴ��ļ������ڷ�������·����ͨ����������
	private String uploadPath;


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
	public File[] getUpload()
	{
		return upload;
	}

	// upload���Ե�setter����
	public void setUpload(File[] upload)
	{
		this.upload = upload;
	}

	// uploadContentType���Ե�getter����
	public String[] getUploadContentType()
	{
		return uploadContentType;
	}

	// uploadContentType���Ե�setter����
	public void setUploadContentType(String[] uploadContentType)
	{
		this.uploadContentType = uploadContentType;
	}

	// uploadFileName���Ե�getter����
	public String[] getUploadFileName()
	{
		return uploadFileName;
	}

	// uploadFileName���Ե�setter����
	public void setUploadFileName(String[] uploadFileName)
	{
		this.uploadFileName = uploadFileName;
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

	public String execute() throws Exception
	{
		for(int i = 0; i < uploadFileName.length; i++)
		{
			String fn = uploadPath + uploadFileName[i];
			FileOutputStream fos = new FileOutputStream(fn);
			InputStream is = new FileInputStream(upload[i]);
			byte[] buffer = new byte[8192]; // ÿ�ζ�8K�ֽ�
			int count = 0;
			while ((count = is.read(buffer)) > 0)
			{
				fos.write(buffer, 0, count);
			}
			fos.close();
			is.close();
		}
		result = "�ļ��ϴ��ɹ���";
		return "result";
	}


}