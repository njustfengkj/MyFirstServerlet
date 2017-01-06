package chapter25;

import java.lang.reflect.Method;
import org.springframework.aop.*;

public class BeforeAdvice implements MethodBeforeAdvice
{

	public void before(Method method, Object[] args, Object target)
			throws Throwable
	{
		System.out.println("beforeAdvice��" + target.getClass().getName() + "." + method.getName()
				+ "  ����ֵ��" + args[0]);
		if(method.getName().equals("getHello"))
			args[0] = "����";

	}

}
