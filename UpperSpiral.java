import java.util.*;

public class UpperSpiral{

	static int value = 1;
	public static void slot(int i,int j,int k,int l,int a[][]){

		int c = 0;
		for(int n = j,m = i;n<=l;++m,++n){
		
			a[m][n] = value++;		
		}			
		if(i < k || j < l)
			right(i,j,c =(i == 0)?k-1:k-2,l,a);
	}
	public static void right(int i,int j,int k,int l,int a[][]){

		for(int m = k,n = l;m>=i;--m){

			a[m][n] = value++;
		}
		if(i < k || j < l)	
			top(i,j+1,k,l-1,a);
	}
	public static void top(int i,int j,int k,int l,int a[][]){

		for(int m = l,n = i;m>=j;--m){

			a[n][m] = value++;
		}
		if(i < k || j < l)
			slot(i+1,j+1,k,l,a);
	}
	public static void print(int a[][]){

		for(int i = 0;i<a.length;++i){

			for(int j = 0;j<a[0].length;++j){

				if(a[i][j] == 0){
					System.out.print("\t");
				}
				else {
					System.out.print(a[i][j]+"\t");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int input = scan.nextInt();
		int a[][] = new int[input][input];
		slot(0,0,input-1,input-1,a);
		print(a);
		scan.close();
	}
}