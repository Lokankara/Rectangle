package test.java.com.test.horstmann;

public class LotteryArray {
	public static void main(String[] args) {
		final int MAX = 10;
		int[][] odds = new int[MAX + 1][];
		for (int n = 0; n <= MAX; n++) {
			odds[n] = new int[n + 1];
		}

		for (int n = 0; n < odds.length; n++) {
			for (int k = 0; k < odds[n].length; k++) {

				int lottery = 1;
				for (int i = 1; i <= k; i++) {
					lottery = lottery * (n - i + 1) / i;
				}
				odds[n][k] = lottery;
			}
		}
		for (int[] row : odds) {
			for (int odd : row) {
				int step = (odds.length - row.length);
				String repeat = "".repeat(step);
				
				System.out.printf("%s%4d",repeat, odd);
			}
			
			System.out.printf("%n");
		}
	}
}