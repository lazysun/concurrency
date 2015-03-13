package com.snippets;

import java.util.Stack;

public class StackReversal {

	Stack<Integer> stack = new  Stack<Integer>();
	public static void main(String[] args) {
			StackReversal s = new StackReversal();
			s.stack.push(1);
			s.stack.push(2);
			s.stack.push(3);
			s.stack.push(4);
			s.stack.push(5);
			s.stack.push(6);
			System.out.println(s.stack);
			s.f();
			System.out.println("After Reversing");
			System.out.println(s.stack);
			
	}

	void f() {
		int size = stack.size();
		int i=0;
		while(i<size-1) {
            int pop = stack.pop();
			r(pop,i);
			i++;
		}
	}

	void r(int push, int size) {
		 int pop = stack.pop();
		 if(stack.size() == size) {
			 stack.push(push);
		 }else {
			 r(push, size);
		 }
		 stack.push(pop);
		 return;
	}
}
