package com.snippets;
/**
 * Why somebody shouldn't extend thread class
 * @author singhv
 *
 */
public class WaitPuzzle {

	public static void main(String[] args) throws InterruptedException {
		DoNothing doNothing = new DoNothing();
		new WaitForever(doNothing).start();
		new WaitForever(doNothing).start();
		new WaitForever(doNothing).start();
		Thread.sleep(100);
		doNothing.start();
        while(true) {
        	Thread.sleep(10);
        }
	}
	
	
	static class WaitForever extends  Thread {
		
		private DoNothing doNothing;
		
		public WaitForever(DoNothing doNothing) {
			this.doNothing =  doNothing;
		}
		
		@Override
		public void run() {
			synchronized (doNothing) {
				try {
					doNothing.wait(); // will wait forever here as nobody notifies here
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Unreachable Code");
			}
		}
	}
	
    static class DoNothing extends Thread {

		@Override
		public void run() {
			System.out.println("Do Nothing ");
		}
    } 
}
