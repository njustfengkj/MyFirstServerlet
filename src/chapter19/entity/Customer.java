package chapter19.entity;

import java.util.*;


public class Customer
{
    private int id;
    private String name; 
    private Set<Order> orders = new HashSet<Order>();
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
	// name���Ե�getter����
	public String getName()
	{
		return name;
	}
	// name���Ե�setter����
	public void setName(String name)
	{
		this.name = name;
	}
	// orders���Ե�getter����
	public Set<Order> getOrders()
	{
		return orders;
	}
	// orders���Ե�setter����
	public void setOrders(Set<Order> orders)
	{
		this.orders = orders;
	}    


}
