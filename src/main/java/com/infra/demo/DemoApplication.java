package com.infra.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.infra.demo.controller"
})
public class DemoApplication {

    public static void main2(String[] args) {

    	SpringApplication.run(DemoApplication.class, args);
    	System.gc();
    	Triplet<String,Integer,Float> triplet = new Triplet<>();


    }

    public static void main(String[] args){
		HashMap map = new HashMap();
		addDataInMap(map);
		System.out.println(map.size());//guess the output is java call by value or call by reference :O
	}

	public static void addDataInMap(Map<String,String> map){
    	map = new HashMap<>();
    	map.put("demo","demo");
		System.out.println(map.size());
	}


}

class Triplet<V1,V2,V3>{
	private V1 value1;
	private V2 value2;
	private V3 value3;

	public V1 getValue1() {
		return value1;
	}

	public void setValue1(V1 value1) {
		this.value1 = value1;
	}

	public V2 getValue2() {
		return value2;
	}

	public void setValue2(V2 value2) {
		this.value2 = value2;
	}

	public V3 getValue3() {
		return value3;
	}

	public void setValue3(V3 value3) {
		this.value3 = value3;
	}


}