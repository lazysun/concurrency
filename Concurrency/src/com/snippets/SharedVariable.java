package com.snippets;


public class SharedVariable {

	private static int  sharedVariable = 0;
	public static void main(String[] args) throws InterruptedException {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				sharedVariable = 1;
			}
		}).start();
		
		for(int i=0;i<1000;i++) {
			for(;;) {
				if(sharedVariable == 1) {
					break;
				}
			}
		}
		System.out.println("Value of SharedVariable : " + sharedVariable);
	}

}
