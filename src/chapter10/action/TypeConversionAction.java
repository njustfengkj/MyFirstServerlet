package chapter10.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class TypeConversionAction implements Action
{
    private String[] products = new String[3];
    private int[] numbers = new int[3];
    private List<Integer> collections;

	// collections���Ե�getter����
	public List<Integer> getCollections()
	{
		return collections;
	}
	// collections���Ե�setter����
	public void setCollections(List<Integer> collections)
	{
		this.collections = collections;
	}
	// products���Ե�getter����
	public String[] getProducts()
	{
		return products;
	}
	// products���Ե�setter����
	public void setProducts(String[] products)
	{
		this.products = products;
	}
	
	// numbers���Ե�getter����
	public int[] getNumbers()
	{
		return numbers;
	}
	// numbers���Ե�setter����
	public void setNumbers(int[] numbers)
	{
		this.numbers = numbers;
	}
	
	public String execute() throws Exception
	{		
		return SUCCESS;
	}


}