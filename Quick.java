package Algorithms;

import java.util.Scanner;

public class Quick {
	public static int partition(int a[],int start,int end){

		int pivot = a[end];
		int i = start-1;
		for(int j = start;j<end;++j){

			if(a[j] < pivot){
			
				i++;
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		int t = a[i+1];
		a[i+1] = a[end];
		a[end] = t;
		for(int j = 0;j<a.length;++j) {
			
			System.out.print(a[j]+" ");
		}
		System.out.println();
		return (i+1);
	}
	public static void quick(int a[],int start,int end){

		if(start < end){

			int p = partition(a,start,end);
			quick(a,start,p-1);
			quick(a,p+1,end);
		}
	}
	public static void printarr(int a[],int n){

		for(int i = 0;i<n;++i){

			System.out.print(a[i]+" ");
		}
	}
	public static void main(String[] args){

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int a[] = new int[n];
		for(int i = 0;i<n;++i){

			a[i] = scan.nextInt();
		}
		scan.close();
		quick(a,0,n-1);
		printarr(a,n);
	}
}
