import java.util.*;

public class MostWater{

	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Length : ");
		int length = scan.nextInt();
		int a[] = new int[length],max = 0,aa=1;
		for(int i = 0;i<length;++i) a[i] = scan.nextInt();
		
		for(int i = 0;i<length-1;++i){

			aa++;
			if(a[i] * (length-1-i) > max){

				for(int j = length-1;j>i;--j){
					aa++;
					if(a[i]*(j-i) > max) {

						if(a[j]<=a[i] && a[j] * (j - i) > max) max = a[j] * (j - i);
						else if(a[j] > a[i] && a[i] * (j - i) > max)max = a[i] * (j-i);
					}
					else {break;}
				}
			}
			else {break;}
		}
		System.out.println("Output : "+max+"\nNo of Iterations : "+aa);
	}
}