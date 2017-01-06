package chapter14.action;

import com.opensymphony.xwork2.*;
import chapter14.*;


public class ValueStackAction extends ActionSupport
{
    private String value = "ValueStack�е�ֵ";
    private Product product = new Product();
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

	// name���Ե�getter����
	public String getValue()
	{
		return value;
	} 

	// name���Ե�setter����
	public void setValue(String value)
	{
		this.value = value;
	}

	public String execute() throws Exception
	{
		ActionContext context = ActionContext.getContext();
		context.put("valueStackAction", this);
		context.put("newProduct", product);		
		product.setName("���г�");
		product.setPrice((float)343.5);

		return SUCCESS;
	}

}