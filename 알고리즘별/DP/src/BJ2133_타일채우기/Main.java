package BJ2133_타일채우기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 2; i <= n; i += 2) {
			dp[i] = 3 * dp[i - 2];
			for (int j = 0; j < (i / 2 - 1); j++) {
				dp[i] += 2 * dp[j * 2];
			}
		}
		System.out.println(dp[n]);
	}
}
