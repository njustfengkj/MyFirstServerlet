package chapter14.action;

import com.opensymphony.xwork2.*;
import java.util.*;


public class IteratorAction extends ActionSupport
{
    private List<String> poetry = new ArrayList<String>(); 
  
	public List<String> getPoetry()
	{
		return poetry;
	}

	public void setPoetry(List<String> poetry)
	{
		this.poetry = poetry;
	}

	public String execute() throws Exception
	{
		
		poetry.add("������¯������");
		poetry.add("ң���ٲ���ǰ��");
		poetry.add("����ֱ����ǧ��");
		poetry.add("�������������");
		return SUCCESS;
	}

}