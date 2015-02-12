package com.snippets;

import java.util.Arrays;

public class BalancedSetJDK8 {

	int f(int i, int lsum) {
		if(i==a.length) {
			return Math.abs(Arrays.stream(a).sum() - 2*lsum);
		}
		return Math.min(f(i+1, lsum+a[i]), f(i+1, lsum));
	}
    
	public BalancedSetJDK8(int ... a) {
		this.a = a;
	}

	int a[] ;
	
	public static void main(String[] args) {
		{
          BalancedSetJDK8 balancedSet = new BalancedSetJDK8(5,6,1);
          System.out.println(balancedSet.f(0, 0));
		}
		{
			BalancedSetJDK8 balancedSet = new BalancedSetJDK8(1,7,4,11);
	        System.out.println(balancedSet.f(0, 0));
		}
		{
			BalancedSetJDK8 balancedSet = new BalancedSetJDK8(1,5,4,9,6,3);
	        System.out.println(balancedSet.f(0, 0));
		}
	}

}
