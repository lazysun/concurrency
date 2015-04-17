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
 	private final Condition notFull = putLock.newCondition(); // signal when queue is notFull
	
	public LinkedBlockingQueue() {
		this(Integer.MAX_VALUE);
	}

	public LinkedBlockingQueue(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public void add(T t) throws InterruptedException {
		int c = -1;
		final Lock lock = this.putLock;
		final AtomicInteger count = this.count;
		Node<T> node  =  new Node<T>();
		lock.lock();
		try {
			while(count.get() == capacity) {
					notFull.await();
			}
			enqueue(node);
			c = count.getAndIncrement();
			if(c+1 < capacity) {
				notFull.signal();
			}
		}finally {
			lock.unlock();
		}
		if(c == 0) {
			signalNotEmpty();
		}
	}

	@Override
	public T take() throws InterruptedException {
		int c = -1;
		final Lock lock = this.takeLock;
		final AtomicInteger count = this.count;
		Node<T> node  = null;
		lock.lock();
		try {
			while(count.get() == 0) {
				notEmpty.await();
			}
			node = dequeue();
			c = count.getAndDecrement();
			if(c > 1) {
				notEmpty.signal();
			}
		}finally {
			lock.unlock();
		}
		if(c == capacity) {
			signalNotFull();
		}
		return node.t;
	}
	


	private void signalNotEmpty() {
		final Lock lock = this.takeLock;
		lock.lock();
		try {
			notEmpty.signal();
		}finally {
			lock.unlock();
		}
	}
	
	private void signalNotFull() {
		final Lock lock = this.putLock;
		lock.lock();
		try {
			notFull.signal();
		}finally {
			lock.unlock();
		}
	}

	@Override
	public void offer(T t) {
		
	}
	

	private Node<T> dequeue() {
		return null;
	}

	
	private void enqueue(Node<T> node) {
	}
	
	 static class Node<T> {
		 T t;
		 Node<T> next;
	 }

}
