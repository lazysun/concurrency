package com.snippets;

public class MultiSet {
	
	//static int arr [] = {1,5,4,9,6,3};
	//static int arr [] = {5,6,1};
	//static int arr [] = {5,6,1};
	static int arr [] = {1,7,4,11};
	public static void main(String[] args) {
		System.out.println(f(0,0,0));
	}
	
	static int f(int k, int leftSum, int rightSum) {
		if(k>=arr.length) {
			return 0;
		}
		if(k==arr.length-1) {
			return Math.min(Math.abs(leftSum+arr[k]-rightSum), Math.abs(leftSum - rightSum+arr[k])) ; 
		}
		return Math.min(f(k+1, leftSum+arr[k], rightSum) , f(k+1, leftSum, rightSum+arr[k]));
	}
 
}
