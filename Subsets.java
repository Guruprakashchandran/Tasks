import java.util.*;
public class Subsets{

	private void subset(){

		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the length : ");
		final int length = scan.nextInt();
		final int[] array = new int[length];
		for(int i = 0;i<length;++i){

			array[i] = scan.nextInt();
		}
		List<List<Integer>> subsets = new ArrayList();
		subsets.add(new ArrayList());
		for(int i = 0;i<array.length;++i){

			for(int j = 0;j<Math.pow(2,i);++j){
			
				List<Integer> list = new ArrayList(subsets.get(j));
				list.add(array[i]);
				subsets.add(list);				
			}
		}
		for(int i = 0;i<subsets.size();++i){
			System.out.print(subsets.get(i));
		}
	}
	public static void main(String[] args){

		new Subsets().subset();
	}
}