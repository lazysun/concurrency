package com.snippets;

import java.util.HashMap;
import java.util.Map;


public class BalancedSetDP {

	int f(int i, int lsum) {
		if(i==a.length) {
			return Math.abs(sum(a) - 2*lsum);
		}
		return Math.min(f(i+1, lsum+a[i]), f(i+1, lsum));
	}
	
	
	int dp() {
		int l = a.length;
		int T = sum(a);
		int c[][] = new int[l][T+1];
	    for(int i=0;i<l;i++) {
	    	for(int j=0;j<T+1;j++) {
	    		c[i][j] = Integer.MAX_VALUE;
	    	}
	    }
		for(int k=0;k<T+1;k++) {
			c[l-1][k] = Math.min(Math.abs(T-2*k), Math.abs(T-2*(k+a[l-1])) );
		}
		for(int i=l-2;i>=0;i--) {
			for(int j=0;j<T+1-a[i];j++) {
				c[i][j] =Math.min(c[i+1][j+a[i]], c[i+1][j]);
			}
		}
		return c[0][0];
	}
	
	int enhancedDp() {
		class I {
			Map<Integer, Integer>[] maps;
			public I(int m, int t) {
				maps = new Map[m];
			}
			void put(int i, int j, int value) {
				if (maps[i] == null) {
					maps[i] = new HashMap<Integer, Integer>();
				}
				maps[i].put(j, value);
			}
			int get(int i, int j) {
				if (maps[i] == null) {
					return Integer.MAX_VALUE;
				}
				if (maps[i].get(j) == null) {
					return Integer.MAX_VALUE;
				}
				return maps[i].get(j);
			}
		}

		int l = a.length;
		int T = sum(a);
		I x = new I(l, T + 1);

		for (int k = 0; k < T + 1; k++) {
			x.put(
					l - 1,
					k,
					Math.min(Math.abs(T - 2 * k),
							Math.abs(T - 2 * (k + a[l - 1]))));
		}
		for (int i = l - 2; i >= 0; i--) {
			for (int j = 0; j < T + 1 - a[i]; j++) {
				x.put(i, j,
						Math.min(x.get(i + 1, j + a[i]), x.get(i + 1, j)));
			}
		}
		return x.get(0, 0);

	}
	
	public BalancedSetDP(int ... a) {
		this.a = a;
	}

	int a[] ;
	
	public static void main(String[] args) {
		{
			BalancedSetDP balancedSet = new BalancedSetDP(5, 6, 1);
			System.out.println("Recursion : " + balancedSet.f(0, 0));
			System.out.println("DP : " + balancedSet.dp());
			System.out.println("Enhanced DP : " + balancedSet.enhancedDp());
			System.out.println("--");
		}
		{
			BalancedSetDP balancedSet = new BalancedSetDP(1, 7, 4, 11);
			System.out.println("Recursion : " + balancedSet.f(0, 0));
			System.out.println("DP : " + balancedSet.dp());
			System.out.println("Enhanced DP : " + balancedSet.enhancedDp());
			System.out.println("--");
		}
		{
			BalancedSetDP balancedSet = new BalancedSetDP(1, 5, 4, 9, 6, 3);
			System.out.println("Recursion : " + balancedSet.f(0, 0));
			System.out.println("DP : " + balancedSet.dp());
			System.out.println("Enhanced DP : " + balancedSet.enhancedDp());
			System.out.println("--");
		}
	}
	
	public static int sum(int a []) {
		int sum = 0;
		for(int i : a) {
			sum = sum + i;
		}
		return sum;
	}

}
