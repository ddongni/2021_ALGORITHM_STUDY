package BJ10826_피보나치수4;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BigInteger[] dp = new BigInteger[10001];
		for (int i = 0; i < 10001; i++) {
			dp[i] = new BigInteger("0");
		}
		dp[1] = new BigInteger("1");
		BigInteger.valueOf(1);
		int n = sc.nextInt();
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 1].add(dp[i - 2]);
		}
		System.out.println(dp[n]);
	}
}
