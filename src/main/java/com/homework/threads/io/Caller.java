package com.homework.threads.io;

import java.util.concurrent.Callable;

class Caller implements Callable<Wrapper> {
	private final Wrapper wrapper;

	public Caller(Wrapper wrapper) {
		super();
		this.wrapper = wrapper;
	}
	public Wrapper call() {
		this.wrapper.countMarks();
		return this.wrapper;
	}
}
class Runner implements Runnable {
	
	private final Wrapper wrapper;

	public Runner(Wrapper wrapper) {
		super();
		this.wrapper = wrapper;
	}

	@Override
	public void run() {
		this.wrapper.countMarks();
	}
}