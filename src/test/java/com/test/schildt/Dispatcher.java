package com.test.schildt;

public class Dispatcher {
	public static void main(String[] args) {

		Box box = new Box(10, 20, 15);
		BoxWeight wbox1 = new BoxWeight(10, 20, 15, 34.3);
		BoxWeight wbox2 = new BoxWeight(2, 3, 4, 0.076);
		double boxVolume = box.volume();
		double boxWeight = box.weight;
		double wbox1v = wbox1.volume();
		double wbox1w = wbox1.weight;
		double vbox2w = wbox2.volume();
		double wbox2w = wbox2.weight;
		System.out.printf("volumeBox: %s %nboxWeight: %s%n", boxVolume, boxWeight);
		System.out.printf("volumeBox1: %s %nweightBoxWeight: %s%n", wbox1v, wbox1w);
		System.out.printf("volumeBox2: %s %nweightBoxWeight2: %s%n", vbox2w, wbox2w);

		Box plainBox = new Box();

		BoxWeight weightBox = new BoxWeight(3, 5, 7, 8.37);

		double vbw3 = weightBox.volume();
		double wbw3 = weightBox.weight;

		plainBox = weightBox;

		System.out.println(plainBox.volume());
		Shipment shipment1 = new Shipment(10, 20, 15, 10, 3.41);
		Shipment shipment2 = new Shipment(2, 3, 4, 0.76, 1.28);
	}
}
