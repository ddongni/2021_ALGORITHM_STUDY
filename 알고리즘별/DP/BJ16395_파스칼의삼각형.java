package BJ16395_파스칼의삼각형;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			Arrays.fill(dp[i], 1);
		}
		for (int i = 3; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}
		System.out.println(dp[n][k]);
	}
}
