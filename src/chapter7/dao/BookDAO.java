package chapter7.dao;

import java.util.*;

public class BookDAO
{    
	private static Map<String, Integer> books= new LinkedHashMap<String, Integer>();
    static
    {
    	books.put("J2EE�����������Ͱ���", 79);
    	books.put("VISUAL C# 2008��������ʵ�����", 89);
    	books.put("STRUTS 2�������", 69);
    	books.put("ASP����ģ�鿪����ȫ", 69);
    	books.put("ASP.NET 3.5�������ݿ⿪��ʵ����ѧ�ֲ�", 79);
    	books.put("XML��������Ӧ�ã����ݱ�ǡ��������������", 65);
    }
    
    public Map<String, Integer> getBooks(String name)
    {
    	Map<String, Integer> books = new LinkedHashMap<String, Integer>();
    
    	for(Map.Entry<String, Integer> entry: BookDAO.books.entrySet())
    	{
    		if(entry.getKey().toLowerCase().contains(name.toLowerCase()))
    			books.put(entry.getKey(), entry.getValue());
    	}    			    	
    	return books;
    }
    
}

