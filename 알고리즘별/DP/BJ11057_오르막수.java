package BJ11057_오르막수;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] dp = new int[n + 2][10];
		for (int i = 0; i < 10; i++) {
			dp[1][i] = 1;
		}
		for (int i = 2; i <= n + 1; i++) {
			for (int j = 0; j < 10; j++) {
				for (int l = j; l < 10; l++) {
					dp[i][j] += dp[i - 1][l];
				}
				dp[i][j] %= 10007;
			}
		}
		System.out.println(dp[n + 1][0]);
	}
}
