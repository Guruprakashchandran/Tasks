import java.util.*;

public class CoinCom{

	public static void main(String[] args){

		int totalAmount = 1529;
		int[] coins = {3,7,50};
		Arrays.sort(coins);
		int[] value = new int[totalAmount+1];
		Arrays.fill(value,Integer.MAX_VALUE);
		value[0] = 0;
		for(int i = 0;i<coins.length;++i){	
			for(int j= coins[i];j<value.length;++j){
				if(value[j - coins[i]] != Integer.MAX_VALUE){
					
					value[j] = Math.min(value[j],value[j-coins[i]]+1);
				}
			}	
					
		}
		System.out.println(value[value.length-1]!=Integer.MAX_VALUE?"Minimum Coins : "+value[value.length-1]:"Minimum Coins : "+-1);
	}
}