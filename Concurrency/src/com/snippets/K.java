package com.snippets;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class K {
	
	char S [] = {'k','m','k','a','a','a','b','k','k','k','c','b','d'};
	char s [] = {'a','b','c','d'};
	
	Map<Character,Integer> m = new HashMap<Character, Integer>(); // Keeps The number of occurrence of particular character till now
	
	public static void main(String[] args) {
		K f = new K();
		f.init();
		System.out.println(f.f());
	}
	
	void init() {
		for(char i : s) {
			m.put(i, 0);
		}
	}
	
    int f() {
    	Queue<N> q = new LinkedList<N>(); // max length of this list will be longest substring containing all the characters
    	int charFound = 0;
    	int r = Integer.MAX_VALUE ; // Answer:stores length of shortest substring containing all characters of s
     	for(int i=0;i<S.length;i++) {
    		if(m.containsKey(S[i])) {
    			int count = m.get(S[i]);
    			if(count == 0) {
    				charFound ++;
    			}
    			q.add(new N(S[i], i));
    			m.put(S[i], ++count);
    		}
    		while(charFound == s.length) {
    			N p =  q.poll();
    			if(p != null) {
    				 r = i-p.p + 1 < r ? i-p.p +1 : r;
    				 int count  = m.get(p.e);
    				 count --;
    				 m.put(p.e, count);
    				 if(count == 0) {
    					 charFound --;
    				 }
    				 
    			}
    		}
    	}
		return r;
    }
    
    class N {
    	
		public N(char e, int p) {
			this.e = e;
			this.p = p;
		}
		char e;
    	int p;
    	
    } 
}

