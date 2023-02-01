package java_program;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class New_Thinking_Of_Snake_Game {
	
	static int Input;
	static int Row_Value = 0,Column_Value = 0;
	static int boom_Row = 0,boom_Column = 0;
	static int boom_Count = 0;
	static boolean reach = false;
	public static void boom(int[] Row,int[] Column) {
		
		boolean bool = true;
		boom_Row = (int)(Math.random()*(Input - 1 + 1)+0);
		boom_Column = (int)(Math.random()*(Input - 1 + 1)+0);
		for(int i = 0;i<Row.length;++i) {
			
			if(Row[i] == boom_Row && Column[i] == boom_Column) {
				
				bool = false;
			}
		}
		if(bool == false) {
			
			boom(Row,Column);
		}
		reach = false;
		return;
	}
	public static void reached(int[] Row,int[] Column,int j) {
		
		if(Row[j] == boom_Row && Column[j] == boom_Column) {
			
			boom_Count++;
//			boom(Row,Column);
			reach = true;
		}
		return;
	}
	public static boolean print(int[] Row,int []Column) {
		
		boolean bool = true;
		boolean value = false;
		for(int i = 0;i<Row.length;++i) {
			for(int j = i+1;j<Row.length;++j) {
				
				if(Row[i] == Row[j] && Column[i] == Column[j]) {
					
					System.out.println("Snake Attacks Body");
					System.out.println("-------Game Over---");
					bool = false;
				}
			}
		}
		if(bool == true) {
			
			System.out.println("Diretions: ");
			for(int k = 0;k<Input;++k) {
				for(int j = 0;j<Input;++j) {
					for(int ite = 0;ite<Row.length;++ite) {
						
						if(ite == 0 && Row[ite] == k && Column[ite] == j) {
							
							System.out.print("H ");
							value = true;
						}
						else if(ite == Row.length -1 && Row[ite] == k && Column[ite] == j) {
							
							System.out.print("T ");
							value = true;
						}
						else if(Row[ite] == k && Column[ite] == j) {
							
							System.out.print("O ");
							value = true;
						}
					}
					if(k == boom_Row && j == boom_Column && ((boom_Count+1)%5) != 0) {
						
						System.out.print("o ");
						value = true;
					}
					else if(k == boom_Row && j == boom_Column && ((boom_Count+1)%5) == 0) {
						
						System.out.print("0 ");
						value = true;
					}
					if(value == false) {
						
						System.out.print("- ");
					}
					else {
						value = false;
					}
					
				}
				System.out.println();
			}
		}
		return bool;
	}
	public static void changing(int[] Row,int[] Column,int j) {
		
		int row,column;
		row = Row[j];
		column = Column[j];
		Row[j] = Row_Value;
		Column[j] = Column_Value;
		Row_Value = row;
		Column_Value = column;
	}
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter the Pattern Size: ");
		Input = scan.nextInt();
		boolean value_bool = true;
		int Iter = 0;
		int Row[] = new int[Input - 2];
		int Column[] = new int[Input - 2];
//		boom(Row,Column);
		for(int i = 0;i<Input;++i){
			for(int j = 0;j < Input;++j){
				if(i == 1 && j >= 1 && j <= Input - 2){

					Row[Iter] = i;
					Column[Iter] = j;
					Iter++;
				}
			}		
		}
		boom(Row,Column);
		for(int i = 0;i<Input;++i){
			for(int j = 0;j < Input;++j){
				if(i == 1 && j >= 1 && j <= Input - 2){

					if(i == 1 && j == 1){
		
						System.out.print("H ");	
					}
					else if(i == 1 && j == Input - 2){

						System.out.print("T ");
					}
					else{

						System.out.print("O ");
					}
				}
				else if(i == boom_Row && j == boom_Column) {
					
					System.out.print("o ");
				}
				else{

					System.out.print("- ");
				}	
			}
			System.out.println();		
		}
	//	System.out.println(boom_Row +" "+boom_Column);
		String category = "y";
		System.out.println("If You want Any move Please Enter the below options ---");
		System.out.println("T - Top");
		System.out.println("B - Bottom");
		System.out.println("L - Left");
		System.out.println("R - Right");
		do {
			
			if(!category.equalsIgnoreCase("Y")) 
				System.out.println("Wrong Letter Pressed...");
			else {

				System.out.print("Enter the Directions: ");
				String Actions = br.readLine();
				char[] a = Actions.toCharArray();
				
				for(int i = 0;i<Actions.length();++i){
					
					if(value_bool == true) {
						if(a[i] == 'T' || a[i] == 't'){
				
							for(int j = 0;j<Row.length;++j){
	
								if(j == 0 && Row[j]-1 != Row[j+1]){
									
									Row_Value = Row[j];
									Column_Value = Column[j];
									if(Row[j] -1 != -1 ) {
										
										Row[j] = Row[j]-1;
								//	System.out.println("");
									}
									else {
										
										Row[j] = Input - 1;
									}
									reached(Row,Column,j);
								}
								else if(j>0){
									
									changing(Row,Column,j);
								}
								
								else {
									
									System.out.println("You Didn't Move Opposite Side");
									break;
								}
								if(Row.length - 1 == j && reach == true) {
									
									boom(Row,Column);
								}
							}
							value_bool = print(Row,Column);
						}
						else if(a[i] == 'B' || a[i] == 'b') {
							
							for(int j = 0;j<Row.length;++j){
	
								if(j == 0 && Row[j]+1 != Row[j+1]){
									
									Row_Value = Row[j];
									Column_Value = Column[j];
									if(Row[j]+1 != Input) {
										
										Row[j] = Row[j]+1;
									//	System.out.println("");
									}
									else {
										
										Row[j] = 0;
									}
									reached(Row,Column,j);
								}
								else if(j>0){
									
									changing(Row,Column,j);
								}
								else {
									
									System.out.println("You Didn't Move Opposite Side");
									break;
								}
								if(Row.length - 1 == j && reach == true) {
									
									boom(Row,Column);
								}
							}
							value_bool = print(Row,Column);
						}
						else if(a[i] == 'L' || a[i] == 'l') {
							
							for(int j = 0;j<Row.length;++j){
	
								if(j == 0 && Column[j]-1 != Column[j+1]){
									
									Row_Value = Row[j];
									Column_Value = Column[j];
									if(Column[j]-1 != -1) {
									
										Column[j] = Column[j]-1;
										//	System.out.println("");
									}
									else {
										
										Column[j] = Input - 1;
									}
									reached(Row,Column,j);
								}
								else if(j>0){
									
									changing(Row,Column,j);
								}
								else {
									
									System.out.println("You Didn't Move Opposite Side");
									break;
								}
								if(Row.length - 1 == j && reach == true) {
									
									boom(Row,Column);
								}
							}
							value_bool = print(Row,Column);
						}
						else if(a[i] == 'R' || a[i] == 'r') {
							
							for(int j = 0;j<Row.length;++j){
	
								if(j == 0 && Column[j]+1 != Column[j+1]){
									
									Row_Value = Row[j];
									Column_Value = Column[j];
									if(Column[j]+1 != Input) {
										
										Column[j] = Column[j]+1;
										//	System.out.println("");		
									}
									else {
										
										Column[j] = 0;
									}
									reached(Row,Column,j);
								}
								else if(j>0){
									
									changing(Row,Column,j);
								}
								else {
									
									System.out.println("You Didn't Move Opposite Side");
									break;
								}
								if(Row.length - 1 == j && reach == true) {
									
									boom(Row,Column);
								}
							}
							value_bool = print(Row,Column);
						}
					}
					else {
						
						break;      
					}
				}
			}
			if(value_bool == false) {
				break;
			}
			
			System.out.print("Do You Want Continue (Y/N): ");
			category = br.readLine();
		}while(!category.equalsIgnoreCase("N"));
		System.out.println("Eating Boom Count - "+boom_Count);
		System.out.println("Exitted..");
	}
}
