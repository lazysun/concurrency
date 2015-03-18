package com.snippets;

public class Generics {

	
	static <T> T m(String s,  Class<T> clazz) throws InstantiationException, IllegalAccessException {
		return clazz.newInstance();
	}
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Class<Integer> clazz =  Integer.class;
		Integer k = m("Some", clazz);
		Class<String> clazz2 =  String.class;
		String s = m("Some", String.class);
	}
}
 