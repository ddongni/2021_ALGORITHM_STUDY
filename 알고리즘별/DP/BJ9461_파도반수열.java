package BJ9461_파도반수열;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] dp = new long[1001];
		dp[1] = dp[2] = dp[3] = 1;
		dp[4] = dp[5] = 2;
		for (int i = 6; i < 1001; i++) {
			dp[i] = dp[i - 1] + dp[i - 5];
		}
		while (t-- > 0) {
			int n = sc.nextInt();
			System.out.println(dp[n]);
		}
	}
}
