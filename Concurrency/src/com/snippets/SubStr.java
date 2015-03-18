package com.snippets;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SubStr {
 
	char k[] = {'a','b','c'};
	char m[]=  {'s','a','b','v','c','a','b','c','m','a','b'};
	Map<Character, Integer> maps = new HashMap<Character, Integer>();
	int start = 0;
	public static void main(String[] args) {
			
	}
	
	void init() {
		for(char c : k) {
			maps.put(c, -1);
		}
	}
	int f() {
		for(int i=0;i<m.length; i++) {
			if(maps.containsKey(m[i])) {
				if(start == maps.get(m[i])) {
				//   	Character  foundOrder.get(0);
				}
			}
		}
		return -1;
	}

}
