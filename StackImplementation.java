package com.programs;

import java.util.Scanner;
import java.util.Stack;

public class StackImplementation{

	private Stack<Options> backward = new Stack<>();
	private Stack<Options> forward = new Stack<>();
	public static void main(String[] args) {
		
		StackImplementation implement = new StackImplementation();
		implement.process();
	}
	class Options{

		private int option,level;
		Options(int option,int level){
		
			this.option = option;
			this.level = level;	
		}
	}
	private void process(){
		
		Scanner scan = new Scanner(System.in);
		backward.push(new Options(0,0));
		printDetails(0,0);
		int option;
		do{
			System.out.print("Please! select category: ");
			option = scan.nextInt();
			System.out.println();
			if(option == 9){
	
				forward.push(backward.pop());
				if(backward.isEmpty()){

					break;
				}
			}
			else if(option == 8) {
				
				if(forward.isEmpty()) {
					
					break;
				}
				backward.push(forward.pop());
			}
			else {
				forward.clear();
				if(backward.peek().level == 2){
				
					backward.push(new Options(option,backward.peek().level + 1 + option - 1));	
				}		
				else {
					backward.push(new Options(option,backward.peek().level+1));
				}
			}
			Options pageDetails;
			if(option!=8) {
				pageDetails = backward.peek();
			}
			else {
				pageDetails = backward.peek();
			}
			printDetails(pageDetails.option,pageDetails.level);
		}while(option != 0);
		System.out.println("Exitted!!!");	
		scan.close();
	}
	private void print(String[] details){

		for(String v:details) {
			System.out.println(v);
		}	
	}
	private void printDetails(int option,int level){
		
		if(level == 0){
	
			final String s = "Choose Language\n1) Tamil\n2) Malayalam\n3) Kanadam\n4) urudhu\n8) Next\n0) Exit";
			String[] details = s.split("\n",-2);
			print(details);
		}
		else if(level == 1){
	
			final String s1 = "Select Option\n1) Balance\n2) My Offer\n3) New Offer\n8) Next\n9) Back\n0) Exit";
			String[] details = s1.split("\n",-2);
			print(details);
		}
		else if(level == 2){
			String[] details;
			switch(option){
				
				case 1:
					final String s1_1 = "Balance\n1)Current Packs Info\n2) Upcoming Packs Info\n3) Others\n8) Next\n9) Back\n0) Exit";
					details = s1_1.split("\n",-2);
					print(details);
					break;
				case 2:
					final String s1_2 = "My Offer\n1) Pack1\n2) Pack2\n3) Pack3\n8) Next\n9) Back\n0) Exit";
					details = s1_2.split("\n",-2);
					print(details);
					break;
				case 3:
					final String s1_3 = "New Offer\n1) Mrp Product\n8) Next\n9) Back\n0) Exit";
					details = s1_3.split("\n",-2);
					print(details);
					break;
			}
		}
		else if(level == 3){
			String[] details;
			switch(option){

				case 1:
					final String s3_1 = "Current Pack Info\n\n9234949576\nBal.Rs0.01\nOutgoing Validity:27-01-2023\nUnlimited Calls,1.5GB/Day,100 SMS/day\nPack Valid till 27-01-2023\n1536 MB left\n9) Back\n0) Exit";
					details = s3_1.split("\n",-2);
					print(details);
					break;
				case 2:
					final String s3_2 = "Upcoming Pack Info\n\nSorry,We are unable to process your request.\nyou don't have any offer\n9) Back\n0) Exit";
					details = s3_2.split("\n",-2);
					print(details);
					break;
				case 3:
					final String s3_3 = "Others:\nA- Data Changing : No\n9) Back\n0) Exit";
					details = s3_3.split("\n",-2);
					print(details);
					break;
			}
		}
		else if(level == 4){
			String[] details;
			switch(option){

				case 1:
					final String s4_1 = "Pack 1\n\nStay connected with 12GB data at just Rs118\n9) Back\n0) Exit";
					details = s4_1.split("\n",-2);
					print(details);
					break;
				case 2:
					final String s4_2 = "Pack 2\n\nStay connected with 15GB data at just Rs148\n9) Back\n0) Exit";
					details = s4_2.split("\n",-2);
					print(details);
					break;
				case 3:
					final String s4_3 = "Pack 3\n\nStay connected with 4GB data at just Rs64\n9) Back\n0) Exit";
					details = s4_3.split("\n",-2);
					break;
			}
		}
		else if(level == 5){
			final String s5_1 = "Mrp Product\n\nExternal application  down\n9) Back\n0) Exit";
			String[] details = s5_1.split("\n",-2);
			print(details);
		}
	}
}