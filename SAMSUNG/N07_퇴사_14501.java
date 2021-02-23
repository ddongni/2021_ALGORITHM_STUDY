package N07_퇴사_14501;

import java.util.Scanner;
/**
 * 걸린 시간 : 13분 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] dp = new int[n + 2];
		for (int i = 1; i <= n; i++) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			dp[i] = Math.max(dp[i], dp[i - 1]);
			if (i + t > n + 1)
				continue;
			dp[i + t] = Math.max(dp[i + t], dp[i] + p);
		}
		System.out.println(Math.max(dp[n+1], dp[n]));
	}
}
