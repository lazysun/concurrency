package com.snippets;

public class PermInPlace {

	int arr[] = {4,3,2,1};
	public static void main(String[] args) {
		new PermInPlace().f(0);
	}
	
	void f(int n) {
		if(n==arr.length-1) {
			print();
		}
		for(int i=n;i<arr.length;i++) {
			swap(n,i);
			f(n+1);
			swap(n,i);
		}
	}

	private void swap(int n, int i) {
		int temp = arr[n];
		arr[n] = arr[i];
		arr[i] = temp;
	}

	private void print() {
		for(int k: arr) {
			System.out.print(k+", ");
		}
		System.out.println();
	}

	
}

