package com.infra.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 *@author aditya.kurhade
 **/
public class DynamicProxy
{
	@SuppressWarnings("unchecked")
	public static <T> T withLogging(T target, Class<T> interFace)
	{
		return (T) Proxy
				.newProxyInstance(
						interFace.getClassLoader(),
						new Class<?>[] { interFace },
						new LoggingHandler(target)
				);
	}

	public static void main(String[] args)
	{
		Person person = new Person();
		Human human = withLogging(person, Human.class);
		human.walk();
		human.talk();
		human.walk();
		human.talk();
		human.walk();
		human.talk();
		System.out.println(human);
	}
}

interface Human
{
	void walk();

	void talk();
}

class Person implements Human
{

	@Override
	public void walk()
	{
		System.out.println("I'm Walking !");
	}

	@Override
	public void talk()
	{
		System.out.println("I'm Talking !");
	}
}

class LoggingHandler implements InvocationHandler
{

	private final Object               target;
	private   static     Map<String, Integer> calls = new HashMap<>();

	LoggingHandler(Object target)
	{
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
	{
		String name = method.getName();
		if (name.contains("toString"))
		{
			return calls.toString();
		}
		calls.merge(name, 1, Integer::sum);

		return method.invoke(target, args);
	}
}
