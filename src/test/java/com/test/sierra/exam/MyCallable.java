package com.test.sierra.exam;
import java.util.concurrent.Callable;  
import java.util.Random; 

public class MyCallable implements Callable<Random> {

	@Override
	public Random call() throws Exception {
		Random random = new Random();
		random.nextInt(10);
//		Thread.sleep(50);
		return random;
	}

}
