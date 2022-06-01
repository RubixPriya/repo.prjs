package com.rubix.threadSamples;

public class ThreadExample extends Thread{
	
	int i = 0;
	
	public void run(){
		while(!(Thread.currentThread().isInterrupted())) {
		System.out.println("Thread Executing" + Thread.currentThread().getName());
		i++;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Thread.currentThread().interrupt();
		}
		
	}
	
	
		
	
	
	public static void main(String[] args) {
		for (int i = 0; i < 3; i++) {
			ThreadExample t1 = new ThreadExample();
			t1.setName("Thread " + i);
			t1.start();
			//System.out.println(t1.getName() + i);
		}
		System.out.println("Thread Samples");
	}

}
