package BJ15988_123¥ı«œ±‚3;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] dp = new long[1000001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for (int i = 4; i <= 1000000; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % 1000000009;
		}
		while (t-- > 0) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
