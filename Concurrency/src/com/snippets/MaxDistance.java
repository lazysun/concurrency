package com.snippets;

public class MaxDistance {

	//int arr[] = {1,2,3,4,5,6,7,8,9};
	//int arr[] = {9,8,7,6,5,4,3,2,1};
	int arr[] = {4,3,5,2,1,3,2,3};
	int descFromLeft[] = new int[arr.length];
	int descFromRight[] = new int[arr.length];
	public static void main(String[] args) {
			System.out.println("Max Distance : " + new MaxDistance().f());
	}
	
	int f() {
		descFromLeft[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			descFromLeft[i] = arr[i] > descFromLeft[i-1] ? descFromLeft[i-1] : arr[i];
		}
		
		descFromRight[arr.length-1] = arr[arr.length -1];
		for(int i=arr.length-2; i>=0;i--) {
			descFromRight[i]=arr[i] > descFromRight[i+1] ? arr[i] : descFromRight[i+1];
		}
		
		int i=0;
		int j=0;
		int max = -1;		
		while(i<arr.length && j<arr.length) {
			if(descFromLeft[i] < descFromRight[j]) {
				max = max > j-i ? max : j-i;
				j++;
			}else {
				i++;
			}
		}
		return  max;
	}
}
