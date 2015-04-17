package com.ipenned.queue;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayBlockingQueue<T> {
	
	private final int capacity;
	private final AtomicInteger count = new AtomicInteger(0); 
 	private final Lock putLock = new ReentrantLock();
 	private final Lock takeLock = new ReentrantLock();
 	private final Condition notEmpty = takeLock.newCondition(); // putLock will signal that its not empty
 	private final Condition notFull = putLock.newCondition(); // signal when queue is notFull
    private final Object [] items ;
    int takeIndex;
    int putIndex;
 	
	public ArrayBlockingQueue(int capacity) {
		this.capacity = capacity;
		items = new Object[capacity];
		
	}

	public void add(T t) throws InterruptedException {
		int c = -1;
		final Lock lock = this.putLock;
		final AtomicInteger count = this.count;
		lock.lock();
		try {
			while(count.get() == capacity) {
					notFull.await();
			}
			enqueue(t);
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

	public T take() throws InterruptedException {
		int c = -1;
		final Lock lock = this.takeLock;
		final AtomicInteger count = this.count;
		T t = null;
		lock.lock();
		try {
			while(count.get() == 0) {
				notEmpty.await();
			}
			t = dequeue();
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
		return t;
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

	private T dequeue() {
		final Object[] items = this.items;
        @SuppressWarnings("unchecked")
        T x = (T) items[takeIndex];
        items[takeIndex] = null;
        if (++takeIndex == items.length)
            takeIndex = 0;
        return x;
	}

	
	private void enqueue(T t) {
		final Object[] items = this.items;
        items[putIndex] = t;
        if (++putIndex == items.length)
            putIndex = 0;
	}
	

}
