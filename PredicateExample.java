package com.java8.learn;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<Student>();
		students.add(new Student("Pradeep","B",70));
		students.add(new Student("Ashish","B",70));
		students.add(new Student("Deepali","C",60));
		students.add(new Student("Miduna","A",90));
		
		students.forEach(s -> System.out.println(s.getName()+" "+s.getGrade()+"  "+s.getScore()));
		
		System.out.println("filter by student grade B "+ filterByGradeofStudent(students,"B"));
		System.out.println("filter by student grade B "+ filterByScoreofStudent(students,70));
		Predicate<Student> predicateByGrade = s -> s.getGrade().equals("A");
		Predicate <Student> predicatebyScore = s -> s.getScore()>=70; 
		
		System.out.println("filter by student grade A "+ predicateFilterStudent(students,predicateByGrade));
		System.out.println("filter by student score 70 "+ predicateFilterStudent(students,predicatebyScore));
		
		System.out.println("filter by student grade A "+ predicateFilterStudentStream(students,predicateByGrade));
		System.out.println("filter by student score 70 "+ predicateFilterStudentStream(students,predicatebyScore.negate()));
	}
	
	private static List<Student> predicateFilterStudent(
			List<Student> students, Predicate<Student> predicate) {
		List<Student> result = new ArrayList<>();
		for(Student s : students)
		{
			if(predicate.test(s))
				result.add(s);
		}	
		return result;
	}
	private static List<Student> predicateFilterStudentStream(
			List<Student> students, Predicate<Student> predicate) {
		
		return students.stream().filter(predicate).collect(Collectors.<Student>toList());
	}
	private static List<Student> filterByScoreofStudent(List<Student> students, int score) {
		List<Student> result = new ArrayList<>();
		for(Student s : students)
		{
			if(s.getScore()>=score)
				result.add(s);
		}
		return result;
	}
	private static List<Student> filterByGradeofStudent(List<Student> students,
			String grade) {
		List<Student> result = new ArrayList<>();
		for(Student s : students)
		{
			if(s.getGrade().equals(grade))
				result.add(s);
		}
		return result;
	}
	static class Student
	{
		private String name;
		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getGrade() {
			return grade;
		}

		public void setGrade(String grade) {
			this.grade = grade;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		private String grade;
		private int score;
		
		public Student(String name, String grade, int score) {
			super();
			this.name = name;
			this.grade = grade;
			this.score = score;
		}
		@Override
		public String toString(){
			return this.name + " "+this.grade +" "+ this.score;
		}
	}
}
