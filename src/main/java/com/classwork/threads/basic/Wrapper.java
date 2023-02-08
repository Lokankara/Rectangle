package com.classwork.threads.basic;

import java.io.File;

class Wrapper implements Comparable<Wrapper> {
    private final File file;
    private Integer counter;

    public Wrapper(File file) {
        super();
        this.file = file;
    }
    public File getFile() {
        return file;
    }
    public Integer getCounter() {
        return counter;
    }
    public void setCounter(Integer counter) {
        this.counter = counter;
    }
    @Override
    public int compareTo(Wrapper file) {
        return Integer.compare(file.counter, this.counter);
    }
	@Override
	public String toString() {
		return String.format("%s punctuation marks in %s", counter, file.getName());
	}
}
