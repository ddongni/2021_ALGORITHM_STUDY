package BJ2839_º≥≈¡πË¥ﬁ;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[5006];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[3] = dp[5] = 1;
		for (int i = 1; i <= n; i++) {
			if (dp[i] != Integer.MAX_VALUE) {
				dp[i + 3] = Math.min(dp[i + 3], dp[i] + 1);
				dp[i + 5] = Math.min(dp[i + 5], dp[i] + 1);
			}
		}
		System.out.println(dp[n] != Integer.MAX_VALUE ? dp[n] : -1);
	}
}
