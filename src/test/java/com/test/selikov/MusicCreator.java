package com.test.selikov;

interface MusicCreator {
	public Number play();
}

abstract class StringInstrument {
	public Long play() {
		return 3L;
	}
}

class Violin extends StringInstrument implements MusicCreator {
	public Long play() {
 return 12L;
 }
}
