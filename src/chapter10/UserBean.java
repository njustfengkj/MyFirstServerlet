package chapter10;

import java.util.*;

public class UserBean
{
	private String name;
	private String password;
	private int age;
	private Date birthday;

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

	// password���Ե�getter����
	public String getPassword()
	{
		return password;
	}

	// password���Ե�setter����
	public void setPassword(String password)
	{
		this.password = password;
	}

	// age���Ե�getter����
	public int getAge()
	{
		return age;
	}

	// age���Ե�setter����
	public void setAge(int age)
	{
		this.age = age;
	}

	// birthday���Ե�getter����
	public Date getBirthday()
	{
		return birthday;
	}

	// birthday���Ե�setter����
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
	}

}
