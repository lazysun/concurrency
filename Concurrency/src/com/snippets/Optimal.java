package com.snippets;

public class Optimal {

	static int keys[] = {10, 12, 20};
    static int freq[] = {34, 8, 50};
	public static void main(String[] args) {
		System.out.println("min   :" +  f(0,freq.length-1));
	}

	static int f(int i, int j) {
		if(i>j) {
			return 0;
		}
		if(i==j) {
			return freq[i];
		}
		int min = Integer.MAX_VALUE;
		for(int k=i;k<=j;k++) {
			int temp = f(i,k-1)+f(k+1, j);
			min = min > temp ? temp : min;
		}
		return  min+sum(i,j);
	}
	
	static int sum (int i, int j) {
		int sum = 0;
		for(int k=i;k<=j;k++) {
			sum=sum+freq[k];
		}
		return sum;
	}

	
}
