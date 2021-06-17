package BJ9657_돌게임3;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		boolean[] dp = new boolean[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i - 1 >= 0) {
				if (!dp[i - 1]) {
					dp[i] = true;
				}
			}
			if (i - 3 >= 0) {
				if (!dp[i - 3]) {
					dp[i] = true;
				}
			}
			if (i - 4 >= 0) {
				if (!dp[i - 4]) {
					dp[i] = true;
				}
			}
		}
		System.out.println(dp[n] ? "SK" : "CY");
	}
}
