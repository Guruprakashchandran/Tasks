import java.util.*;

public class Jumping_Number{

	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		int a[] = new int[Integer.toString(num).length()];
		int i = a.length-1;
		while(num != 0){

			a[i--] = (num%10);
			num /= 10;
		}
		i = 0;
		int start = i;
		int end = i+1;
		while(end != a.length){
			
			System.out.println(a[start]+""+a[end]);
			if(a[start]<a[end]){
				if(a[start]+1<a[end]){

					for(int j = end;j<a.length;++j){

						a[j] = a[j-1]+1;
					}
				}
				else if(i+1 == start){

					i = start;
				}
				a[end] = a[start] + 1;
				System.out.println(1+" "+a[start]+" "+a[end]);
				start++;
				end++;
			}
			else if(a[start]-1<=a[end] && a[start]!=0){

				a[end] = a[start] - 1;
				start++;
				end++;
				System.out.println(2+" "+a[start-1]+" "+a[end-1]);
				
			}
			else {
				int k = i;
				if(i!= 0){
			
					a[i] = a[i] - 2;
					start = i;
					end = start+1;
				}
				else {
					if(a[i] == 1){

						a[i] = 0;
						start = ++i;
						end = start + 1;
					}
					else {

						a[i] -= 1;
						start = i;
						end = start+1;
					}
				}
				for(int j = k+1;j<a.length;++j){

					a[j] = 9;
				}
				System.out.println(3+" "+a[start]+" "+a[end]);
			}
		}
		i = 0;
		while(i!=a.length){

			num = num * 10 + a[i++];			
		}
		System.out.println(num);
	}
}