package chapter19.entity;


public class Person
{
	private int id;
	private Name name;
	private java.util.Date birthday;

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
	public Name getName()
	{
		return name;
	}

	// name���Ե�setter����
	public void setName(Name name)
	{
		this.name = name;
	}

	// birthday���Ե�getter����
	public java.util.Date getBirthday()
	{
		return birthday;
	}

	public String formatBirthday()
	{
		java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
				"yyyy-MM-dd");
		return format.format(birthday);
	}

	public void setBirthday(java.util.Date birthday)
	{
		this.birthday = birthday;
	}
}
