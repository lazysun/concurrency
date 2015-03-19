package com.snippets;

public class Bitwise {

	public static void main(String[] args) {
		testShift();
	}
	
	static void  testShift() {
		int i=Integer.MIN_VALUE;
		System.out.println(i);
		System.out.println(Integer.toBinaryString(i));
		System.out.println(i>>31);
		System.out.println(Integer.toBinaryString(i>>31));
		System.out.println(i>>32);
		System.out.println(Integer.toBinaryString(i>>32));
	}
}
