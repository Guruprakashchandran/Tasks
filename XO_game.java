package java_program;

import java.util.Scanner;

public class XO_game {
	
	static char a[][] = new char[3][3];
	static String player1,player2;
	static boolean bool = false;
	static int ind = 0;
	public static void checking_Player(char c) {
		
		if((a[0][0] == c && a[0][1] == c && a[0][2] == c) ||(a[1][0] == c && a[1][1] == c && a[1][2] == c) || (a[2][0] == c && a[2][1] == c && a[2][2] == c) || (a[0][0] == c && a[1][0] == c && a[2][0] == c) || (a[0][1] == c && a[1][1] == c && a[2][1] == c) || (a[0][2] == c && a[1][2] == c && a[2][2] == c) || (a[0][0] == c && a[1][1] == c && a[2][2] == c) || (a[0][2] == c && a[1][1] == c && a[2][0] == c)) {
			
			if(c == 'X') {
				
				System.out.println("\n-----------"+player1+ " the Winner!!!-------------\n");
				bool = true;
			}
			else if(c == 'O') {
				
				System.out.println("\n------------"+player2 +" the Winner!!!------------\n");
				bool = true;
			}
		}
	}
//	public static void checking_Player1() {}
	public static void print() {
		
		System.out.println("----Output----");
		for(int i = 0;i<3;++i) {
			for(int j = 0;j<3;++j) {
				if(a[i][j] == 'X') {
					
					if(j == 2) {
						
						System.out.print("X");
					}
					else {
					
						System.out.print("X|");
					}
				}
				else if(a[i][j] == 'O') {
					
					if(j == 2) {
						
						System.out.print("O");
					}
					else {
					
						System.out.print("O|");
					}
				}
				else {
					
					if(j == 2) {
						
						System.out.print(" ");
					}
					else {
					
						System.out.print(" |");
					}
				}
			}
			if(i != 2) {
				
				System.out.println("\n- - -");
			}
			else {
				System.out.println();
			}
		}
	}
	public static void reserve() {
		
		System.out.println();
		for(int i = 0;i<3;++i) {
			for(int j = 0;j<3;++j) {
				
				a[i][j] = '0';
				if(j == 2) {
					
					System.out.print(" ");
				}
				else {
				
					System.out.print(" |");
				}
			}
			if(i != 2) {
			
				System.out.println("\n- - -");
			}
			else {
				System.out.println();
			}
		}
	}
	public static void position_Place(String position,char pos,int index) {
		
		try {
		int i,j;
		char c[] = position.toCharArray();
		i = Character.getNumericValue(c[0]);
		j = Character.getNumericValue(c[2]);
		if(a[i][j]=='0') {
			
			a[i][j] = pos;
			ind++;
		}
		else {
			
			System.out.println("\nPlease!!! Enter Correct Position");
			System.out.println("Re-Enter the Position");
		}
		if(index > 3) {
			
			checking_Player(pos);
		}
		print();
		}
		catch(Exception e) {
			
			System.out.println("Please!!! Enter Correct Position");
			System.out.println("Re-Enter the Position");
		}
	}
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("X/O Game\n");
		reserve();
		System.out.print("Enter Player 1 Name : ");
		player1 = scan.nextLine();
		System.out.print("Enter Player 2 Name : ");
		player2 = scan.nextLine();
		String position ="";
		char pos = '0';
		String value = "";
		while(ind < 9) {
			
			if(ind%2 == 0) {
				
				System.out.println("Player - "+player1);
				System.out.print("Enter the Position :");
				value = scan.nextLine();
				//position = scan.nextLine();
				pos = 'X';
			}
			else if(ind%2 == 1) {
				
				System.out.println("Player - "+player2);
				System.out.print("Enter the Position :");
//				position = scan.nextLine();
				value = scan.nextLine();
				pos = 'O';
			}
			
			if(value.equalsIgnoreCase("Exit")) {
				
				if(ind % 2 == 0) {
					
					System.out.println(player1+" : Exitted");
				}
				else {
					
					System.out.println(player2 +" : Exitted");
				}
				break;
			}
			switch(Integer.parseInt(value)) {
			
				case 1:
					
					position = "0,0";
					break;
				case 2:
					
					position = "0,1";
					break;
				case 3:
					
					position = "0,2";
					break;
				case 4:
					
					position = "1,0";
					break;
				case 5:
					
					position = "1,1";
					break;
				case 6:
					
					position = "1,2";
					break;
				case 7:
					
					position = "2,0";
					break;
				case 8:
					
					position = "2,1";
					break;
				case 9:
					
					position = "2,2";
					break;
				default :
					
					System.out.println("\nPlease!!! Enter Correct Position");
					System.out.println("Re-Enter the Position");
			}
			position_Place(position,pos,ind);
			if(bool == true ) {
				
				break;
			}
		}
		System.out.print("If you want Restart the Game!!!");
		System.out.print("Enter --Yes---");
		if(scan.nextLine().equalsIgnoreCase("Yes")) {
			
			main(null);
		}
	}
}
