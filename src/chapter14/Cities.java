package chapter14;

public class Cities
{
	public City[] getCities()
	{
		City[] cities = new City[4];
		cities[0] = new City("bj", "����");
		cities[1] = new City("sh", "�Ϻ�");
		cities[2] = new City("gz", "����");
		cities[3] = new City("others", "����");
		return cities;
	}

}
