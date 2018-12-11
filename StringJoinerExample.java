package com.java8.learn;

import java.util.Arrays; 
import java.util.List; 
import java.util.StringJoiner; 
import java.util.stream.Collectors;



public class StringJoinerExample {

	/**
	 * @param args
	 */
	@SuppressWarnings("empty-statement")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 // Example 1 - joining stirng by comma 
		StringJoiner joiner = new StringJoiner(",", "[", "]");
		String joined = joiner.add("Sony").add("Apple").add("Google").toString(); 
		System.out.println("joined String by a comma: " + joined); 
		
		// Example 2 - let's join String by pipe 
		StringJoiner joinByPipe = new StringJoiner("|"); 
		String pipe = joinByPipe.add("iPhone").add("iPhone6").add("iPhone6S").toString(); 
		System.out.println("joined String by pipe: " + pipe); 
		
		//Exmaple 3 - Joining using String.join(). It internally 
		// uses StringJoiner though 
		String bestCreditCards = String.join(",", "Citibank", "Bank Of America", "Chase");
		System.out.println("bestCreditCards: " + bestCreditCards); 
		
		// You can use this to create path in file system e.g. 
		String pathInLinux = String.join("/", "", "usr", "local", "bin"); 
		System.out.println("path in Linux : " + pathInLinux); 
		String pathInWindows = String.join("\\", "C:", "Program Files", "Java"); 
		System.out.println("path in Windows : " + pathInWindows); 
		
		// Example 4 - Joint Stirng from a List 
		List<String> typesOfLoan = Arrays.asList("home loan", "personal loan", "car loan", "balance transfer"); 
		String loans = String.join(",", typesOfLoan); System.out.println("joining list elements: " + loans); 
		
		// Example 5 - Joining String from array with a delimeter 
		String[] typesOfFee = {"admin fee", "processing fee", "monthly fee"}; 
		String fees = String.join(";", typesOfFee); 
		System.out.println("joining array elements: " + fees); 
		
		// Example 6 - Joining String using Collectors 
		List<String> list = Arrays.asList("life insurance", "health insurance", "car insurance"); 
		String fromStream = list.stream() .map(String::toUpperCase) .collect(Collectors.joining(", ")); 
		System.out.println("joining stream elements : " + fromStream); 
		
		// Example 7 - manually prior to Java 8 
		List<String> magic = Arrays.asList("Please", "Thanks"); 
		System.out.println("joined : " + join(magic, ","));;

	}
	public static String join(List<String> list, String delimeter) 
	{ 
		StringBuilder sb = new StringBuilder(); 
		boolean first = true; 
		for (String item : list) 
		{ 
			if (first) { 
				first = false; 
			} 
			else { 
				sb.append(delimeter); 
				} sb.append(item); 
		} 
		return sb.toString(); 
	} 



}
