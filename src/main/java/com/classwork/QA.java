package com.classwork;

import java.util.Objects;

public class QA implements Runnable {

	private String answer;

	public static void main(String[] args) {
		Runnable run = new QA();
		Thread tread = new Thread(run);
		tread.start();
	}

	@Override
	public int hashCode() {
		return Objects.hash(answer);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QA other = (QA) obj;
		return Objects.equals(answer, other.answer);
	}

	@Override
	public void run() {
		System.out.println("TODO Auto-generated method stub");
	}
}
