package chapter10.action;

import com.opensymphony.xwork2.*;
import chapter10.Product;


//public class ProductAction implements Action
public class ProductAction extends ActionSupport
{
	private Product product;	
	
	// product���Ե�getter����
	public Product getProduct()
	{
		return product;
	}

	// product���Ե�setter���� 
	public void setProduct(Product product)
	{
		this.product = product;
	}
	public String execute() throws Exception
	{			 	
		return SUCCESS;
	}


}