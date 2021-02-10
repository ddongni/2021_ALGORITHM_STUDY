package N05_123더하기4_15989;

import java.util.Scanner;
/**
 * 1차원 배열 풀이 방법도 있음
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[][] dp = new int[10001][4];
		dp[1][1] = dp[2][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;
		for (int i = 4; i <= 10000; i++) {
			dp[i][1] = 1;
			for (int j = 2; j <= 3; j++) { // j로 시작 되는 수열
				for (int k = 1; k <= j; k++) {
					dp[i][j] += dp[i - j][k];
				}
			}
		}
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			System.out.println(dp[n][1]+dp[n][2]+dp[n][3]);
		}
	}
}
