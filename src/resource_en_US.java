import java.util.ListResourceBundle;

public class resource_en_US extends ListResourceBundle
{
	private final Object resources[][] = 
	{
	    { "product.name", "product name�����ļ���" }, 
	    { "product.price", "product price�����ļ���" },
	    { "message", "Hello,{0}! Now is {1}�����ļ���" } 
	};
	@Override
	protected Object[][] getContents()
	{	
		return resources;
	}
}
