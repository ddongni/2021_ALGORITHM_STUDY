package BJ13301_타일장식물;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] dp = new long[81];
		dp[1] = dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		System.out.println(4 * dp[n] + 2 * dp[n - 1]);
	}
}
