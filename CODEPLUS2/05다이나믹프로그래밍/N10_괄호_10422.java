package N10_괄호_10422;

import java.util.Scanner;

/**
 * (올바른 괄호 문자열) 올바른 괄호 문자열
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] dp = new long[5001];
		dp[0] = 1;
		dp[2] = 1;
		for (int i = 4; i < 5001; i += 2) {
			int diff = i - 2;
			for (int j = 0; j <= diff; j++) {
				dp[i] += dp[j] * dp[diff-j];
				dp[i] %= 1000000007;
			}
		}
		for (int i = 0; i < t; i++) {
			System.out.println(dp[sc.nextInt()]);
		}
	}
}
