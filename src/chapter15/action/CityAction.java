package chapter15.action;

import com.opensymphony.xwork2.*;
import java.util.*;

public class CityAction extends ActionSupport
{		
	private String province;
    private static Map<String, List<String>> provinces = new HashMap<String, List<String>>();
    private int cityCount = 0;
    static
    {
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
    }
    
	// province���Ե�getter����
	public String getProvince()
	{
		return province;
	}

	// province���Ե�setter����
	public void setProvince(String province) throws Exception
	{
		this.province = province;
	}

	// provinces���Ե�getter����
	public Set<String> getProvinces()
	{
		return provinces.keySet();
	}
    public int getProvinceCount()
    {
    	return getProvinces().size();
    }
    public List<String> getCities()
    {    	
    	List<String> cities = provinces.get(province);
    	cityCount = cities.size();
    	return cities;
    }
	public int getCityCount()
	{
		return cityCount;
	}
	public String provinces() throws Exception
	{		
	
		return SUCCESS;
	}

	public String cities() throws Exception
	{
		
		return SUCCESS;
	}	
}