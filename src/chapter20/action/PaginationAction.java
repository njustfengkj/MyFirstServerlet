package chapter20.action;

import hibernate.HibernateSessionFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import com.opensymphony.xwork2.*;
import java.util.*;

public class PaginationAction extends ActionSupport
{
    private String entity;
    private String fields;
    private int rows;
    private int currentPage;  
    private List records = new ArrayList();     	
	public String execute() throws Exception
	{
		Session session = HibernateSessionFactory.getSession();
		Criteria crit = session.createCriteria(entity);
        crit.setFirstResult((currentPage - 1) * rows);
        crit.setMaxResults(rows);        
		List list = crit.list();
		for (Object obj : list)
		{			
			records.add(obj);
		}
		session.close();
		return SUCCESS;
	}

	// fields���Ե�getter����
	public String getFields()
	{
		return fields;
	}


	// fields���Ե�setter����
	public void setFields(String fields)
	{
		
		this.fields = fields;
	}
	// rows���Ե�getter����
	public int getRows()
	{
		return rows;
	}

	// rows���Ե�setter����
	public void setRows(int rows)
	{
		this.rows = rows;
	}

	// entity���Ե�getter����
	public String getEntity()
	{
		return entity;
	}


	// entity���Ե�setter����
	public void setEntity(String entity)
	{
		this.entity = entity;
	}


	// currentPage���Ե�getter����
	public int getCurrentPage()
	{
		return currentPage;
	}


	// currentPage���Ե�setter����
	public void setCurrentPage(int currentPage)
	{
		this.currentPage = currentPage;
	}


	// records���Ե�getter����
	public List<List<String>> getRecords()
	{
		return records;
	}


	// records���Ե�setter����
	public void setRecords(List<List<String>> records)
	{
		this.records = records;
	}

	// fieldList���Ե�getter����
	public String[] getFieldList()
	{		
		return fields.split(",");
	}
}