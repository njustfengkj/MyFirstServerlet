import java.util.ListResourceBundle;

public class resource_zh_CN extends ListResourceBundle
{
	private final Object resources[][] = 
	{
	    { "product.name", "��Ʒ�������ļ���" }, 
	    { "product.price", "��Ʒ�۸����ļ���" },
	    { "message", "��ã�{0}�����ڵ�ʱ����{1}�����ļ���" } 
	};
	@Override
	protected Object[][] getContents()
	{		
		return resources;
	}
}
