package com.infra.demo.decorator;

/**
 *@author aditya.kurhade
 **/
public class DecoratorDemo
{
	public static void main(String[] args)
	{
		ColoredShape<Square> green = new ColoredShape<>("green", new Square());

		System.out.println(green.info());
	}
}

interface Shape{
	String info();
}

class Square implements Shape{

	@Override
	public String info()
	{
		return " Square shape !";
	}
}

class Circle implements Shape{

	@Override
	public String info()
	{
		return  "Circle Shape !";
	}
}

class ColoredShape<T extends Shape> implements Shape{

	private String color;
	private Shape shape;

	public ColoredShape(String color, T shape)
	{
		this.color = color;
		this.shape = shape;
	}

	@Override
	public String info()
	{
		return " INFO : " + shape.info() + " || color : " + color;
	}
}



