package com.rubix.threadSamples;

public class ThreadPractice implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Thread Executing" + " " + Thread.currentThread().getName() );
		
		
	}
	
	public static void main(String[] args) {
		Thread thread  = new Thread(new ThreadPractice());
		thread.setName("FirstName");
		thread.start();
		//thread.run();
		
		Thread thread1 = new Thread(new ThreadPractice());
		thread1.setName("SecondName");
		thread1.run();
		thread1.start();
		thread1.run();
		
	}

}


