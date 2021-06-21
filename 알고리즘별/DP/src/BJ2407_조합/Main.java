package BJ2407_а╤гу;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		BigInteger[][] dp = new BigInteger[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= i; j++) {
				dp[i][j] = new BigInteger("1");				
				if (i != j && j != 0) {
					dp[i][j] = dp[i - 1][j - 1].add(dp[i - 1][j]);
				}
			}
		}
		System.out.println(dp[n][m]);
	}
}
