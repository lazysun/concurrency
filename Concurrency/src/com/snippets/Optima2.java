package com.snippets;

public class Optima2 {
	
	static int keys[] = {10, 12, 20};
    static int freq[] = {34, 8, 50};
    static int arr[][];
	public static void main(String[] args) {
		arr = new int [freq.length][freq.length];
		for(int i=0;i<freq.length;i++) {
			arr[i][i] = freq[i];
		}
	}
   
	static int f(int i, int j) {
		int min = Integer.MAX_VALUE;
		for(int k=i;k<=j;k++) {
			int temp = arr[i][k-1]+arr[k+1][j];
			min = min > temp ? temp : min;
		}
		arr[i][j] = min+sum(i,j);
		return arr[i][j];
	}
	 
	static int sum (int i, int j) {
		int sum = 0;
		for(int k=i;k<=j;k++) {
			sum=sum+freq[k];
		}
		return sum;
	}

}
