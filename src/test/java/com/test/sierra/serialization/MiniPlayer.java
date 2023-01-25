package com.test.sierra.serialization;

import java.io.*;

class ElectronicDevice implements Serializable {
	static final long serialVersionUID = -1898240645L;
	ElectronicDevice() {
		System.out.print("ed ");
	}
}

class Mp3player extends ElectronicDevice implements Serializable {
	static final long serialVersionUID = -189821340645L;
	Mp3player() {
		System.out.print("mp ");
	}
}

class MiniPlayer extends Mp3player {
	static final long serialVersionUID = -189551340645L;
	MiniPlayer() {
		System.out.print("mini ");
	}

	public static void main(String[] args) {
		MiniPlayer m = new MiniPlayer();
		try {
			FileOutputStream fos = new FileOutputStream("dev.txt");
			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(m);
			os.close();
			FileInputStream fis = new FileInputStream("dev.txt");
			ObjectInputStream is = new ObjectInputStream(fis);
			MiniPlayer m2 = (MiniPlayer) is.readObject();
			is.close();
		} catch (Exception x) {
			System.out.print("x ");
		}
	}
}
