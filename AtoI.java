import java.util.*;

public class AtoI{
	public static void main(String[] args){

		int n = new Scanner(System.in).nextInt();
		int a = 0,k=5;
		while(k<=n){
				
			a+= n/k;
			k *= 5;
		}
		System.out.println(a);
	}
}