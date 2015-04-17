package com.ipenned.queue;

public interface BlockingQueue<T> {
	
	void add(T t) throws InterruptedException;
	
	void offer(T t);
	
	T take() throws InterruptedException;
}
