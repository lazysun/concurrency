package com.snippets;

public class Perm {
	
	public static void main(String[] args) {
	  new Perm().f(0);
	}
	
	int arr[] = {1,2,3,4};
	
	void f(int k) {
		if(k==arr.length - 1) {
			print();
		}
		for(int i=k;i<arr.length;i++) {
			swap(k,i);
			f(k+1);
			swap(k,i);
		}
	}

	private void print() {
		for(int m : arr) {
			System.out.print(m+", ");
		}
		System.out.println("");
	}

	private void swap(int k, int i) {
		int temp = arr[k];
		arr[k] = arr[i];
		arr[i] = temp;
	}
}

