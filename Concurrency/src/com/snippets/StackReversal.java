package com.snippets;

import java.util.Stack;

public class StackReversal {
	
	public static void main(String[] args) {
			StackReversal s = new StackReversal();
			System.out.println(s.stack);
			s.f();
			System.out.println("After Reversing");
			System.out.println(s.stack);
			
	}
	void f() {
		for(int i=0; i<stack.size()-1;i++) {
			r(stack.pop(),i);
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
	}
	
	Stack<Integer> stack = new  Stack<Integer>();
	StackReversal() {
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
	}
}
