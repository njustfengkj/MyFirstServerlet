package chapter25;

public class MyClass implements MyInterface
{

	public String getHello(String name)
	{
		System.out.println("����getHello����");
		return "hello " + name;
	}

	public int getRandomInt(int max)
	{
		java.util.Random random = new java.util.Random();
		random.nextInt(max);
		System.out.println("����getRandomInt����");
		return random.nextInt(max);
	}
}
