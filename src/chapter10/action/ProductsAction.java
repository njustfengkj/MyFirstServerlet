package chapter10.action;

import com.opensymphony.xwork2.*;
import chapter10.Product;
import java.util.*;

//public class ProductsAction implements Action
public class ProductsAction extends ActionSupport
{
	private Product product1;
	private Product product2;
	
	private Product[] products;
    private List<Product> productList;
    
    private List myProductList;
    private Map myProductMap;
    private Set myProductSet;
    
	// myProductSet���Ե�getter����
	public Set getMyProductSet()
	{
		return myProductSet;
	}

	// myProductSet���Ե�setter����
	public void setMyProductSet(Set myProductSet)
	{
		this.myProductSet = myProductSet;
	}

	// myProductList���Ե�getter����
	public List getMyProductList()
	{
		return myProductList;
	}

	// myProductList���Ե�setter����
	public void setMyProductList(List myProductList)
	{
		this.myProductList = myProductList;
	}

	// myProductMap���Ե�getter����
	public Map getMyProductMap()
	{
		return myProductMap;
	}

	// myProductMap���Ե�setter����
	public void setMyProductMap(Map myProductMap)
	{
		this.myProductMap = myProductMap;
	}

	// products���Ե�getter����
	public Product[] getProducts()
	{
		return products;
	}

	// products���Ե�setter����
	public void setProducts(Product[] products)
	{
		this.products = products;
	}

	// product1���Ե�getter����
	public Product getProduct1()
	{
		return product1;
	}

	// product1���Ե�setter����
	public void setProduct1(Product product1)
	{
		this.product1 = product1;
	}

	// product2���Ե�getter����
	public Product getProduct2()
	{
		return product2;
	}

	// product2���Ե�setter����
	public void setProduct2(Product product2)
	{
		this.product2 = product2;
	}

	public String execute() throws Exception
	{			 	

		return SUCCESS;
	}

	// productList���Ե�getter����
	public List<Product> getProductList()
	{
		return productList;
	}

	// productList���Ե�setter����
	public void setProductList(List<Product> productList)
	{
		this.productList = productList;
	}
}