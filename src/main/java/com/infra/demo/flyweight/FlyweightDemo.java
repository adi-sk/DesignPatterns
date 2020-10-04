package com.infra.demo.flyweight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 *@author aditya.kurhade
 **/
// this design pattern is used for space optimization.
public class FlyweightDemo
{
	public static void main(String[] args)
	{
		User2 aditya_kurhade = new User2("Aditya Kurhade");
		User2 aditya_kur = new User2("Aditya Kur");
		User2 adi_kurhade = new User2("Adi Kurhade");

		System.out.println(adi_kurhade.getFullName());
		System.out.println(aditya_kur.getFullName());
		System.out.println(aditya_kurhade.getFullName());
	}
}

//without flyweight -- without space optimization.
class User
{
	private String fullName;

	public User(String fullName)
	{
		this.fullName = fullName;
	}

	public String getFullName()
	{
		return fullName;
	}
}

// with flyweight -- with space optimization.

class User2
{
	private static List<String> names = new ArrayList<>();
	private  int[]        nameIndex;

	public User2(String fullName)
	{
		Function<String, Integer> getOrAdd = (String s) -> {
			int idx = names.indexOf(s);
			if (idx != -1)
				return idx;
			else
			{
				names.add(s);
				return names.size() - 1;
			}
		};

		nameIndex = Arrays.stream(fullName.split(" ")).mapToInt(s -> getOrAdd.apply(s)).toArray();
	}

	public String getFullName()
	{
		StringBuilder nameToReturn= new StringBuilder();
		for (int i : nameIndex){
			nameToReturn.append(names.get(i));
			nameToReturn.append(" ");
		}
		return nameToReturn.toString();
	}
}
