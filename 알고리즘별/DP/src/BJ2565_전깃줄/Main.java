package BJ2565_ภüฑ๊มู;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[501];
		for (int i = 0; i < n; i++) {
			array[sc.nextInt()] = sc.nextInt();
		}
		int[] dp = new int[501];
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < 501; i++) {
			if (array[i] != 0) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (array[j] < array[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
				ans = Math.max(ans, dp[i]);
			}
		}
		System.out.println(n - ans);
	}
}