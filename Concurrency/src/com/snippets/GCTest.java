package com.snippets;

import java.util.LinkedList;
import java.util.List;

public class GCTest {

	
	public static void main(String[] args) {
        GCTest gcTest = new GCTest();
        gcTest.testOverHeadLimit();  
	}
	
	void testOverHeadLimit() {
		int limit = 1000000000;
		System.out.println(limit);
		List<Integer> list = new LinkedList<>();
		int i=0;
		for(i=0;i<limit;i++) {
			list.add(i);
		}
		int max  = i;
		while(i< max) {
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			list.add(++i);
		}
	}

}
