package com.snippets;

public class BalancedSet {

	int f(int i, int lsum, int rsum) {
		if(i==a.length) {
			return Math.abs(lsum-rsum);
		}
		return Math.min(f(i+1, lsum+a[i], rsum), f(i+1, lsum, rsum+a[i]));
	}
    
	public BalancedSet(int ... a) {
		this.a = a;
	}

	int a[] ;
	
	public static void main(String[] args) {
		{
          BalancedSet balancedSet = new BalancedSet(5,6,1);
          System.out.println(balancedSet.f(0, 0, 0));
		}
		{
			BalancedSet balancedSet = new BalancedSet(1,7,4,11);
	        System.out.println(balancedSet.f(0, 0, 0));
		}
		{
			BalancedSet balancedSet = new BalancedSet(1,5,4,9,6,3);
	        System.out.println(balancedSet.f(0, 0, 0));
		}
	}

}
