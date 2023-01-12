package com.test.heller;

//enum Animals { LION, TIGER, BEAR }

//enum Animals {
// int age;
// LION, TIGER, BEAR;
//}

//enum Animals {
// LION, TIGER, BEAR;
// int weight;
//}

//enum Animals {
// LION(450), TIGER(450), BEAR;
// int weight;
// Animals(int w) {
// weight = w;
// }
//}
enum Animals {
	LION(450), TIGER(450), BEAR;

	int weight;

	Animals() {
	}

	Animals(int w) {
		weight = w;
	}
}