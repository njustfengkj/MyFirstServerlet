package chapter14;

public class City
{
    private String abbreviation;
    private String name;
    
  
    public City(String abbreviation, String name)
    {
    	this.abbreviation = abbreviation;
    	this.name = name;
    }

	public String getAbbreviation()
	{
		return abbreviation;
	}

	public void setAbbreviation(String abbreviation)
	{
		this.abbreviation = abbreviation;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
}
