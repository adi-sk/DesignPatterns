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
