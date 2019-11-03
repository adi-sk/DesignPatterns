package com.infra.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;
import java.util.LinkedList;

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
		LinkedList<String> strings = new LinkedList<>();
		HashMap<String, LinkedList<String>> stringLinkedListHashMap = new HashMap<>();

		strings.add("12121212121212");
		strings.add("demid");

		stringLinkedListHashMap.put("demo",strings);
		System.out.println(stringLinkedListHashMap);
		strings.clear();


	}

}
