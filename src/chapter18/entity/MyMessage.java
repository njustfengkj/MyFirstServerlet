package chapter18.entity;
import javax.persistence.*;
@Entity
@Table(name="t_message")
public class MyMessage
{

	private int id; // ��Ӧid�ֶ�
	private String name; // ��Ӧname�ֶ�
	// id���Ե�getter����
    @Id
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


}
