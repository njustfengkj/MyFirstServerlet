package chapter19.entity;

public class Order
{
	private int id;
	private String number;
	private Customer customer;
	
	// id���Ե�getter����
	public int getId()
	{
		return id; 
	}
	// id���Ե�setter����
	public void setId(int id)
	{
		this.id = id;
	}
	// number���Ե�getter����
	public String getNumber()
	{
		return number;
	}
	// number���Ե�setter����
	public void setNumber(String number)
	{
		this.number = number;
	}
	// customer���Ե�getter����
	public Customer getCustomer()
	{
		return customer;
	}
	// customer���Ե�setter����
	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}


}
