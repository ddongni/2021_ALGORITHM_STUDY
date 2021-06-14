package BJ2011_암호코드;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] n = sc.next().split("");
		int[] array = new int[n.length];
		for (int i = 0; i < n.length; i++) {
			array[i] = Integer.parseInt(n[i]);
		}
		long[] dp = new long[5001];
		dp[0] = dp[1] = 1;
		if (array[0] == 0) {
			System.out.println(0);
			return;
		}
		for (int i = 2; i <= array.length; i++) {
			if (array[i - 1] != 0) {
				dp[i] = (dp[i] + dp[i - 1]) % 1000000;
			}
			int x = array[i - 2] * 10 + array[i - 1];
			if (x >= 10 && x <= 26) {
				dp[i] = (dp[i] + dp[i - 2]) % 1000000;
			}
		}
		System.out.println(dp[n.length]);
	}
}
