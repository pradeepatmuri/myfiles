package com.java8.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;



class Employee{
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	Employee(int id,String name)
	{
		this.id = id;
		this.name=name;
	}
	public String toString(){
		return this.id +"   "+this.name;
	}
}
public class Java8Stream {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empList = new ArrayList<Employee>();
		empList.add(new Employee(1,"Pradeep"));
		empList.add(new Employee(2,"Ashish"));
		empList.add(new Employee(3,"Deepali"));
		empList.add(new Employee(4,"Midhuna"));
		empList.add(new Employee(5,"Amar"));
		empList.add(new Employee(6,"Amit"));
		empList.add(new Employee(7,"Sakshi"));
		empList.add(new Employee(8,"Babu"));
		empList.add(new Employee(9,"Babu"));
		
		//streamFilterDisplay(empList);
		//streamSort(empList);
		//streamMap(empList);
		//streamCount(empList);
		streamMatch(empList);
		List<String> names = Arrays.asList(new String[]{"pradeep","khan","deep","deep","pradeep","4"});   
		names.stream().filter(i -> !(Collections.frequency(names, i) >1))
        .collect(Collectors.toSet()).forEach(System.out::println);
		
		List<Integer> numbers1 = Arrays.asList(new Integer[]{1,20,3,4,4,5});   
		Integer x = numbers1.stream().max(Integer::compare).get();
		System.out.println(x);
		
	}
	public static void streamFilterDisplay(List<Employee> empList){
		System.out.println("Stream filter with A letter");
		// -- Stream filter
		empList.stream().filter(e -> e.getName().startsWith("A")).forEach(System.out::println);
	}
	
	public static void streamSort(List<Employee> empList){
		System.out.println("");
		System.out.println("Stream sort by using method reference ");
		//sorted(Collections.reverseOrder())
		Comparator<Employee> customComparator =  (e1,e2) ->  e1.getName().compareTo(e2.getName());
		empList.stream().sorted(customComparator).forEach(System.out::println);
		System.out.println("Stream sort by using lambda expression ");
		empList.stream().sorted((e1,e2) ->  e2.getName().compareTo(e1.getName())).forEach((e)-> System.out.println(e));
	}
	
	public static void streamMap(List<Employee> empList){
		System.out.println("");
		System.out.println("Stream map");
		empList.stream().map((e) -> e.getName().toUpperCase()).forEachOrdered( (e)-> System.out.println(e));

	}
	
	public static void streamCount(List<Employee> empList){
		System.out.println("");
		System.out.println("Stream count");
		System.out.println(empList.stream().count());
	}
	public static void streamMatch(List<Employee> empList) {
		System.out.println("");
		System.out.println("Stream match");
		System.out.println("Stream anymatch  -- "+empList.stream().anyMatch((e) -> e.getName().equalsIgnoreCase("pradEEP")));
		System.out.println("Stream allmatch  -- "+empList.stream().allMatch((e) -> e.getName().equalsIgnoreCase("pradEEP")));
		System.out.println("Stream nonematch  -- "+empList.stream().noneMatch((e) -> e.getName().equalsIgnoreCase("pradEEP")));
	}
}
