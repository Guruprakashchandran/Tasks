package com.programs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Person{
	
	private String name;
	private int age;
	Person(String name,int age){
		
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
class QueueOperation{
	
	Queue<Person> queue = new LinkedList<>();
	public boolean callPerson() {
		
		try {
			if(queue.isEmpty()) {
				
				System.out.println("No One Candidates are there!!\n");
			}
			else {
				System.out.println("\n---------Candidate Details----------------");
				System.out.println("The Candidate Name : "+queue.peek().getName());
				System.out.println("The Candidate Age : "+queue.remove().getAge()+"\n");
			}
		}
		catch(Exception e) {
			
			System.out.println(e.toString());
		}
		return true;
	}
	public boolean insertPersonDetails() {
		
		Scanner scan;
		try {
		
			scan = new Scanner(System.in);
			System.out.println("--------Person Details-------");
			System.out.print("Enter the Name : ");
			String name = scan.nextLine();
			System.out.print("Enter the Age : ");
			int age = scan.nextInt();
			scan.nextLine();
			Person Detail = new Person(name,age);
			queue.add(Detail);
			System.out.println("Data Added!!!");
		}
		catch(Exception e) {
			
			System.out.println(e.toString());
		}
		return true;
	}
	public void persons(){
		 
		Scanner scan;
		int number;
		boolean iteration = true;
		try {
			while(iteration) {
			
				scan = new Scanner(System.in);
				System.out.println("-------------:Main Page:---------------");
				System.out.println("1 Call Person");
				System.out.println("2 Insert Person Details");
				System.out.println("3 Exit");
				System.out.print("Enter the Input : ");
				number = scan.nextInt();
				scan.nextLine();
				switch(number) {
				
					case 1:
						iteration = callPerson();
						break;
					case 2:
						iteration = insertPersonDetails();
						break;
					case 3:
						System.out.println("Exitted!!");
						iteration = false;
						break;
					default:
						System.out.println("Wrong Input!!!");
						new QueueOperation().persons();
				}
				
			}
		}
		catch(Exception e) {
			
			System.out.println(e.toString());
		}
		finally {
			
			scan = null;
		}
	}
}
public class InterviewProcess {

	public static void main(String[] args) {
		
		QueueOperation operation = new QueueOperation();
		operation.persons();
	}
}