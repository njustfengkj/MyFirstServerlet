package chapter10.action.ognl;

import com.opensymphony.xwork2.*;
import chapter10.Product;
import java.util.*;

public class ProductsAction implements Action
{

    private Map<String, Product> products;
	

	// products���Ե�getter����
	public Map<String, Product> getProducts()
	{
		return products;
	}


	// products���Ե�setter����
	public void setProducts(Map<String, Product> products)
	{
		this.products = products;
	}

	public String execute() throws Exception
	{			 	
		return SUCCESS;
	}


	

}