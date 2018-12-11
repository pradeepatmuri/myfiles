package com.java8.learn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Stream1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("int stream");
		Stream<Integer> intStream = Stream.of(1,2,3,4,5,6);
		intStream.forEach(i -> System.out.print(i +" "));
		
		System.out.println("\ncreation of stream by using array");
		Stream<String> strStream = Stream.of(new String[]{"pradeep","khan","dan"});
		strStream.forEach(s -> System.out.print(s+" "));
		
		System.out.println("\ncreation of stream by using array second way");
		Integer[] intArray = new Integer[]{1,2,3,4,5,6,8,9};
		Stream<Integer> intStream1 = Stream.of(intArray);
		intStream1.forEachOrdered(i-> System.out.print(i));
		
		System.out.println("\ncreation of stream by using array List ");
		List<Integer> list = Arrays.asList(new Integer[]{100,101,102,103});
		Stream<Integer> listStream = list.stream();
		listStream.forEach(s -> System.out.print(s + " "));
		System.out.println("");
		list.stream().forEach(s -> System.out.print(s + " "));
		
		/*Stream<Date> streamdate = Stream.generate(() -> { return new Date();});
		streamdate.forEach(p -> System.out.println(p));*/
		System.out.println("\n next example");
		IntStream stream = "12345_abcdefg".chars();
        stream.forEach(p -> System.out.println(p));
        
        List<Integer> list1 = new ArrayList<Integer>();
        for(int i = 1; i< 10; i++){
            list1.add(i);
        }
        Stream<Integer> stream1 = list1.stream();
        List<Integer> evenNumbersList = stream1.filter(i -> (i%2 == 0)).collect(Collectors.toList());
        for(Integer i : evenNumbersList)
            System.out.print(" "+i);
        
        
        Integer[] evenNumbersArr = list1.stream().filter(i -> i%2 == 0).toArray(Integer[]::new);
        for(Integer i : evenNumbersArr)
        	 System.out.print(" "+i);
        
	}

}
