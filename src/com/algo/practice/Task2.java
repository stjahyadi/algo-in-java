package com.algo.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Parent{
	protected int age;
	
	@Override
	public void finalize() throws Throwable{
		System.out.println("asd");
	}
}

class Child extends Parent{
	@Override
	public void finalize() throws Throwable{
		System.out.println("qwe");
	}
}

abstract class Animal1{
	abstract void hello();
}

public class Task2 {
	public static void main(String[] args) {
		String[] strs = new String[] {"abD", "aB", "ABC", "ccDe", "CDd"};
		Collections.sort(Arrays.asList(strs), String::compareToIgnoreCase);
		System.out.println(strs[0]);
		
		List<Integer> numbers= Arrays.asList(1,3,7,4,6,8,10);
		numbers.stream().map(i -> i * 1.0 / numbers.stream().mapToInt(Integer::intValue).sum());
		
		//Animal1  animal = new Animal1();
		//animal.hello();
		
		Map<Person, String> map = new HashMap<>();
		Person person1 = new Person("Smith", "Person");
		Person person2 = new Person("Smith", "Person");
		
		map.put(person1, "person1");
		System.out.println(map.get(person2));
	}
}

class Person {
	
	private String surname;
	private String name;
	
	public Person(String surname, String name) {
		this.name=  name;
		this.surname=surname;
	}
}
