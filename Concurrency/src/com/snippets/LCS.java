package com.snippets;

public class LCS {

	public static void main(String [] args) {
	System.out.println(new LCS().lcs("AGGTAB".toCharArray(),"AGGTAB".length()-1,  "GXTXAYB".toCharArray(), "GXTXAYB".length()-1));
	System.out.println(new LCS().lcs("ABCDGH".toCharArray(),"ABCDGH".length()-1,  "AEDFHR".toCharArray(), "AEDFHR".length()-1));
	}
	
	
	int lcs(char [] a, int m, char [] b, int n) {
		int l[][] = new int[m+2][n+2];
		for(int i=0;i<=m;i++) {
			for(int j=0;j<=n;j++) {
				if(a[i] == b[j]) {
					l[i+1][j+1]= 1+l[i][j];
				}else {
					l[i+1][j+1]= Math.max(l[i][j+1], l[i+1][j]);
				}
			}
		}
		return l[m+1][n+1];
	}
}
