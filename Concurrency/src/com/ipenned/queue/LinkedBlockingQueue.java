package com.ipenned.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingQueue<T> implements BlockingQueue<T> {
	
	private final int capacity;
	private final AtomicInteger count = new AtomicInteger(0); 
 	private final Lock putLock = new ReentrantLock();
 	private final Lock takeLock = new ReentrantLock();
 	private final Condition notEmpty = takeLock.newCondition(); // putLock will signal that its not empty
 	private final Condition notFull = putLock.newCondition(); // takeLock will signal that its not empty
	
	public LinkedBlockingQueue() {
		this(Integer.MAX_VALUE);
	}

	public LinkedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public void add(T t) {
		int c;
		putLock.lock();
		try {
			c = count.get();
			while(c == capacity) {
				try {
					notFull.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} 
				c = count.get();
			}
			
		}finally {
			putLock.unlock();
		}
	}

	@Override
	public void offer(T t) {
		
	}

	@Override
	public T take() {
		return null;
	}

}
