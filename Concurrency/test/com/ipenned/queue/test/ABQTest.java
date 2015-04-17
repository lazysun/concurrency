package com.ipenned.queue.test;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
//import java.util.concurrent.ArrayBlockingQueue;
import com.ipenned.queue.ArrayBlockingQueue;

public class ABQTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() throws InterruptedException {

		final ArrayBlockingQueue<Integer> q = new ArrayBlockingQueue<Integer>(16); 
		ExecutorService e1 = Executors.newFixedThreadPool(16);
		for(int i=0; i < 10000; i++ ) {
			final int k = i;
			e1.submit(new Runnable() {
				@Override
				public void run() {
					int  sleepTime =  (int) (5*Math.random());
					try {
						Thread.sleep(sleepTime);
						System.out.println("Put : " + k  + " th item" );
						q.add(k);
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}
			});

			e1.submit(new Runnable() {
				@Override
				public void run() {
					try {
						int  sleepTime =  (int) (3*Math.random());
						Thread.sleep(sleepTime);
						System.out.println("----- " + q.take());
					} catch (InterruptedException e) {
						Thread.currentThread().interrupt();
						e.printStackTrace();
					}
				}
			});
		}
		e1.awaitTermination(1, TimeUnit.MINUTES);
	}

}
