package com.ipenned.queue;

public interface BlockingQueue<T> {
	
	void add(T t);
	
	void offer(T t);
	
	T take();
}
