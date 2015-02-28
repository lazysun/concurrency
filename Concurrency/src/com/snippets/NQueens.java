package com.snippets;

public class NQueens {

	public static void main(String[] args) {
		NQueens nQ = new NQueens(8);
		nQ.finit();
		nQ.print();
        
	}
	
	void finit() {
		int s[][] = new int[this.n][2];
		for(int i=0; i < n; i++ ) {
			for(int j=0; j < n ;j++) {
			    s[0][0] = i;
 			    s[0][1] = j;
				if(f(i,j,s, 1)) {
					c[i][j]=1;
					return;
				}
			}
		}
	}
	
	boolean f(int l, int m, int s[][], int q) {
		int mm = m+1;
		for(int i=l;  i < n; i++ ) {
			for(int j=mm;j < n; j++) {
				if(!isValid(i, j, s, q)) {
					continue;
				}
				s[q][0] = i;
				s[q][1] = j;
				if(q ==  n-1) {
					c[i][j] = 1;
					return true;
				}else if(f(i,j, s, q+1)) {
					c[i][j] = 1;
					return true;
				}
			}
			mm=0;
		}	
		return false;
	}
	
	private boolean isValid(int i, int j, int[][] s, int q) {
		for(int k=0;k<q;k++) {
			if(i==s[k][0]) {
				return false;
			}
			if(j==s[k][1]) {
				return false;
			}
			if(Math.abs(i-s[k][0]) == Math.abs(j-s[k][1])) {
				return false;
			}
		}
		return true;
	}
	
	int n;
	int c[][];

	public NQueens(int n) {
		this.n = n;
		c = new int[n][n];
	}

	void print() {
	 	for(int j [] : c) {
	 		for(int k : j) {
	 			System.out.print(k+", ");
	 		} 
	 		System.out.println("");
	 	}
	}

}
