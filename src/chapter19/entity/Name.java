package chapter19.entity;

public class Name
{
    private String first;
    private String last;
    
	
	// first���Ե�getter����
	public String getFirst()
	{
		return first;
	}


	// first���Ե�setter����
	public void setFirst(String first)
	{
		this.first = first;
	}


	// last���Ե�getter����
	public String getLast()
	{
		return last;
	}


	// last���Ե�setter����
	public void setLast(String last)
	{
		this.last = last;
	}


	public String toString()
	{
		return first + " " + last;
	}
}
