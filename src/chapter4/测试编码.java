package chapter4;

class ��
{
	public void ��()
	{
		System.out.println("����");
	}

	public void ��()
	{
		System.out.println("����");
	}
}

public class ���Ա���
{

	public static void main(String[] args) throws Exception
	{
		�� С�� = new ��(); // ʵ����������
		С��.��(); // ���á��ɡ�����
		С��.��(); // ���á���"����
		String s = "����";

		byte[] utf8 = s.getBytes("utf-8");
		System.out.println(new String(utf8, "gbk"));
		for (int i = 0; i < utf8.length; i++)
		{
			System.out.print(Integer.toHexString(0xff & utf8[i]) + " ");
		}
		System.out.println(new String(s.getBytes("ISO-8859-1"), "GBK"));
		
		System.out.println(new String(s.getBytes("Unicode"), "Unicode"));
	}

}
