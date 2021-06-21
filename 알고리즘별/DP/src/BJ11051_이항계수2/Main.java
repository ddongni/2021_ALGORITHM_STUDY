package BJ11051_이항계수2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = 1;
				if (j != 0 && i != j) {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % 10007;
				}
			}
		}
		System.out.println(dp[n][k]);
	}
}
