package chapter15.action;

import java.util.*;
import com.opensymphony.xwork2.Action;
import com.googlecode.jsonplugin.annotations.JSON;

public class MyJSON
{
	private  int num1;
	private  int num2;
	private int sum;
    private String province;

	private static Map<String, List<String>> provinces = new HashMap<String, List<String>>();

	public String execute()
	{
		sum = num1 + num2;

		List<String> cities_ln = new ArrayList<String>();
		cities_ln.add("������");
		cities_ln.add("������");
		cities_ln.add("��Ϫ��");
		cities_ln.add("��˳��");
		provinces.put("����", cities_ln);
		List<String> cities_gd = new ArrayList<String>();
		cities_gd.add("������");
		cities_gd.add("�麣��");
		cities_gd.add("��ͷ��");
		cities_gd.add("������");
		provinces.put("�㶫", cities_gd);
		List<String> cities_hxj = new ArrayList<String>();
		cities_hxj.add("��������");
		cities_hxj.add("���������");
		cities_hxj.add("������");
		cities_hxj.add("��ľ˹��");
		provinces.put("������", cities_hxj);

		return Action.SUCCESS;
	}

	// num1���Ե�getter����
	public int getNum1()
	{
		return num1;
	}

	// num1���Ե�setter����
	public void setNum1(int num1)
	{
		this.num1 = num1;
	}

	// num2���Ե�getter����
	public int getNum2()
	{
		return num2;
	}

	// num2���Ե�setter����
	public void setNum2(int num2)
	{
		this.num2 = num2;
	}

	// sum���Ե�getter����
	public int getSum()
	{
		return sum;
	}

	// sum���Ե�setter����
	public void setSum(int sum)
	{
		this.sum = sum;
	}
	
	public List<String> getCities()
	{
	
		return  provinces.get(province);
	}

	// province���Ե�getter����
	public String getProvince()
	{
		return province;
	}

	// province���Ե�setter����
	public void setProvince(String province)
	{
		this.province = province;
	}

	// provinces���Ե�getter����
	@JSON(name="myProvinces")
	public Map<String, List<String>> getProvinces()
	{
		return provinces;
	}
	
	
}