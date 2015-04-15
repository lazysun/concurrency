package com.snippets;

public class LPS {

	
	public static void main(String args[]) {
		System.out.println(new LPS().lps("GEEKSFORGEEKS".toCharArray()));
		System.out.println(new LPS().lps("GEEKS FOR GEEKS".toCharArray()));
		System.out.println(new LPS().lps("XAYBZBA".toCharArray()));
	}
	
	
	int lps(char arr[]) {
		int n = arr.length;
		if(n == 0) {
			return 0;
		} 
		int l[][] = new int[n][n];
		
		for(int i=0; i<n; i++) {
			l[i][i] = 1;
		} 
		String s ="";
		String e ="";
		for(int k=1;k<n;k++) {
			for(int i=0;i<n-k;i++) {
				int j=i+k;
				if(arr[i] == arr[j]) {
					l[i][j] = 2 + l[i+1][j-1];
					s=s+arr[i];
					e=e+arr[j];
				}else {
					l[i][j] = Math.max(l[i+1][j], l[i][j-1]);
				}
			}
			
		}
		System.out.println(s);
		return l[0][n-1];
	}
}
