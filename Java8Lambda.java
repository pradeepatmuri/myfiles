package com.java8.learn;

public class Java8Lambda {
	@FunctionalInterface
	   interface MathOperation {
	      int operation(int a, int b);
	      default int calculation(int a,int b){
	    	  return a+b;
	      }
	   }
   public static void main(String args[]){
	   
		
	   MathOperation additionanno = new MathOperation(){

		@Override
		public int operation(int a, int b) {
			return a+b;
		}
		   
	   };
	  System.out.println("annonymas class "+additionanno.operation(6, 9)); 
     
	  //with type declaration
      MathOperation addition = (int a, int b) -> a + b;
      
      System.out.println("default mehod caluculation of interface "+addition.calculation(1,1));
      //with out type declaration
      MathOperation subtraction = (a, b) -> a - b;
		
      //with return statement along with curly braces
      MathOperation multiplication = (int a, int b) -> { return a * b; };
		
      //without return statement and without curly braces
      MathOperation division = (int a, int b) -> a / b;
      
      Java8Lambda tester = new Java8Lambda();
      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
      //without parenthesis
      GreetingService greetService1 = message -> System.out.println("Hello " + message);
		
      //with parenthesis
      GreetingService greetService2 = (message) -> System.out.println("Hi " + message);
		
      greetService1.sayMessage("Mahesh");
      greetService2.sayMessage("Suresh");
   }
   private int operate(int a, int b, MathOperation mathOperation){
      return mathOperation.operation(a, b);
   }
   interface GreetingService {
	      void sayMessage(String message);
	   }
		
}