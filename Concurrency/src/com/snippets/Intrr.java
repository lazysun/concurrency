package com.snippets;

public class Intrr {

	public static void main(String[] args) {
		String spreadFactor = "13.5";
		int k = spreadFactor.indexOf(".");
		System.out.println(spreadFactor.length()-k-1);
		if(spreadFactor.length()-k-1 > 2 ) {
			System.out.println("Invalid");
		}
	}

}
