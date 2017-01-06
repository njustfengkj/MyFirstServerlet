package chapter14.action;

import com.opensymphony.xwork2.*;
import org.apache.struts2.util.IteratorGenerator.Converter;

public class ErrorsAction extends ActionSupport
{
	@Override
	public String execute() throws Exception
	{
		addFieldError("field1", "field1�ĵ�һ��������Ϣ!");
		addFieldError("field1", "field1�ĵڶ���������Ϣ!");
		addFieldError("field2", "field2�ĵ�һ��������Ϣ!");
		
		addActionError("��һ��Action����!");
		addActionError("�ڶ���Action����!");
		
		addActionMessage("��һ��Action��Ϣ!");
		addActionMessage("�ڶ���Action��Ϣ��");
		return SUCCESS;
	}
}