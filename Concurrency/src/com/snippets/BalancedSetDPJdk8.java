package com.snippets;

import java.util.Arrays;

public class BalancedSetDPJdk8 {

	int f(int i, int lsum) {
		if(i==a.length) {
			return Math.abs(Arrays.stream(a).sum() - 2*lsum);
		}
		return Math.min(f(i+1, lsum+a[i]), f(i+1, lsum));
	}
	
	
	int dp() {
		int m = a.length;
		int T = Arrays.stream(a).sum();
		int c[][] = new int[m][T+1];
	    for(int i=0;i<m;i++) {
	    	for(int j=0;j<T+1;j++) {
	    		c[i][j] = Integer.MAX_VALUE;
	    	}
	    }
		for(int k=0;k<T+1;k++) {
			c[m-1][k] = Math.min(Math.abs(T-2*k), Math.abs(T-2*(k+a[m-1])) );
		}
		for(int i=m-2;i>=0;i--) {
			for(int j=0;j<T+1-a[i];j++) {
				c[i][j] =Math.min(c[i+1][j+a[i]], c[i+1][j]);
			}
		}
		return c[0][0];
	}
	
	public BalancedSetDPJdk8(int ... a) {
		this.a = a;
	}

	int a[] ;
	
	public static void main(String[] args) {
		{
          BalancedSetDPJdk8 balancedSet = new BalancedSetDPJdk8(5,6,1);
          System.out.println("Recursion : " + balancedSet.f(0, 0));
          System.out.println("DP : " + balancedSet.dp());
		}
		{
			BalancedSetDPJdk8 balancedSet = new BalancedSetDPJdk8(1,7,4,11);
			System.out.println("Recursion : " + balancedSet.f(0, 0));
			System.out.println("DP : " + balancedSet.dp());
		}
		{
			BalancedSetDPJdk8 balancedSet = new BalancedSetDPJdk8(1,5,4,9,6,3);
			System.out.println("Recursion : " + balancedSet.f(0, 0));
			System.out.println("DP : " + balancedSet.dp());
		}
	}

}
