package Algorithms;

import java.util.Scanner;

public class Find_Paths {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int st_I,end_I,st_J,end_J;
		st_I = scan.nextInt();
		st_J = scan.nextInt();;
		end_I = scan.nextInt();
		end_J = scan.nextInt();
		scan.close();
		for(int i = 0;i<n;++i) {
			
			for(int j = 0;j<n;++j) {
				
				if(i == st_I && j == st_J) {
					
					System.out.print("H ");
				}
				else if(i == end_I && j == end_J) {
					
					System.out.print("O ");
				}
				else {
					
					System.out.print("- ");
				}
			}
			System.out.println();
		}
	}
}
