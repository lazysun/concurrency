package com.snippets;

public class BS {

	public static void main(String[] args) {
			BS bs = new BS();
			int f = bs.f(new int[]{1,1,2,4,5}, 0, 4, 99);
			System.out.println(f);
	}

	int f(int a[], int s, int e, int key) {
		while(e-s > 1) {
			int m = s+(e-s)/2;
			if(a[m]<=key) {
				s = m;
			}else {
				e=m;
			}
		}
		return a[s];
	}
}
