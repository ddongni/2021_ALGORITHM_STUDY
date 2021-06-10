package BJ11722_가장긴감소하는부분수열;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = n - 1; i >= 0; i--) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n];
		Arrays.fill(dp, 1);
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
					dp[i] = dp[j] + 1;
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
