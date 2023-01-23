package java_program;

import java.util.Scanner;

public class CalenderCreation {

	public static int find_Day(long year) {
	
		long leap,nonLeap,total_Day;
		year = year-1;
		leap = year/4 - (year/100) + (year/400);
		nonLeap = year - leap;
		total_Day = (leap * 366) + (nonLeap * 365) + 1;
		return (int)total_Day % 7;
	}
	public static void year(int day,int month[],String years[]) {
		
		for(int i = 0;i<12;++i) {
			System.out.println("\t\t\t"+years[i]+"\n");
			System.out.println("sun\tmon\ttue\twed\tthu\tfri\tsat");
			boolean bool = false;
		
			for(int k = 0,j = 0;j<month[i];) {
				if((k++)!= day && bool == false) {
					System.out.print("\t");
				}
				else {
					bool = true;
					System.out.print(++j +"\t");
				}
				if(k % 7 == 0 && bool == true) {
					System.out.println();
				}
			}
	
			day = ((day + (month[i])) % 7);
			System.out.println("\n");
		}
	}
	public static void main(String[] args) {
		
		Scanner scan =  new Scanner(System.in);
		int feb;
		System.out.print("Enter the Year : ");
		int year = scan.nextInt(),day;
		if(year % 400 == 0  || (year % 4 == 0 && year %100 != 0)) {
			feb = 29;
		}
		else {
			feb = 28;
		}
		int month[] = {31,feb,31,30,31,30,31,31,30,31,30,31};
		String years[] = {"jan","feb","mar","apr","may","jun","jul","aug","sep","oct","nov","dec"};
		day = find_Day(year);
		year(day,month,years);
		scan.close();
	}
} 