package chapter16.model;

public class User
{
    private  String username;
    private String password;
    private String repassword;
    private String email;
    private String validationCode;
	// validationCode���Ե�getter����
	public String getValidationCode()
	{
		return validationCode;
	}
	// validationCode���Ե�setter����
	public void setValidationCode(String validationCode)
	{
		this.validationCode = validationCode;
	}
	// username���Ե�getter����
	public String getUsername()
	{
		return username;
	}
	// username���Ե�setter����
	public void setUsername(String username)
	{
		this.username = username;
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
	// email���Ե�getter����
	public String getEmail()
	{
		return email;
	}
	// email���Ե�setter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	// repassword���Ե�getter����
	public String getRepassword()
	{
		return repassword;
	}
	// repassword���Ե�setter����
	public void setRepassword(String repassword)
	{
		this.repassword = repassword;
	}
}
