package BJ2294_µ¿Àü2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] dp = new int[k + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < n; j++) {
				if (i - arr[j] >= 0 && dp[i - arr[j]] != Integer.MAX_VALUE) {
					dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
				}
			}
		}
		System.out.println(dp[k] == Integer.MAX_VALUE ? -1 : dp[k]);
	}
}
