package com.snippets;

public class BSA {

	public static void main(String[] args) {
		{
			int arr[] = {1,2,3,4};
			System.out.println(f(arr, 0 , arr.length-1, 0));
		}
		

		{
			int arr[] = {1};
			System.out.println(f(arr, 0 , arr.length-1, 0));
		}
		
		{
			int arr[] = {1};
			System.out.println(f(arr, 0 , arr.length-1, 2));
		}
		
		{
			int arr[] = {1,2,3,3,3,3,3,3,5};
			System.out.println("2 : =  " + f(arr, 0 , arr.length-1, 3));
		}
		
		{
			int arr[] = {3,3,3,3,3,3,2};
			System.out.println("0 : =  " + f(arr, 0 , arr.length-1, 3));
		}
		
		{
			int arr[] = {3,5};
			System.out.println("0 : =  " + f(arr, 0 , arr.length-1, 3));
		}
		
		{
			int arr[] = {1,2,3};
			System.out.println("2 : =  " + f(arr, 0 , arr.length-1, 3));
		}
		
		{
			int arr[] = {1,2,3};
			System.out.println("-1 : =  " + f(arr, 0 , arr.length-1, 5));
		}
		{
			int arr[] = {-1, 2, 3, 5, 6, 8, 9, 10};
			System.out.println("6 : =  " + arr[floor(arr, 0 , arr.length-1, 7)]);
		}
		{
			int arr[] = {3,4,5};
			System.out.println("5 : =  " + arr[floor(arr, 0 , arr.length-1, 5)]);
		}
	
	}

	static int f(int arr[], int s, int e, int k) {
		if(s > e) return -1;
		if(s == e) return arr[s] == k ? s : 10000;
		int m = s+(e - s)/2;
		if(arr[m] >= k) {
			return f(arr, s, m, k);
		}else {
			return f(arr,m+1,e, k);
		}
	}
	
	static int floor(int arr[], int s, int e, int k) {
		while(e-s > 1) {
			int m = s + (e - s) /2;
			if(arr[m] <= k) 
				s = m;
			else
				e = m;
		}
		return s;
	}
	
	static int floor(int arr[], int s, int e, int k) {
		while(e-s > 1) {
			int m = s + (e - s) /2;
			if(arr[m] >= k) 
				e = m;
			else
				s = m;
		}
		return s;
	}
	
	static int f2(int A[], int l, int r, int key) {
		int m;
		 
	    while( r - l > 1 )
	    {
	        m = l + (r - l)/2;
	 
	        if( A[m] >= key )
	            r = m;
	        else
	            l = m;
	    }
	 
	    return r;
	}
}
