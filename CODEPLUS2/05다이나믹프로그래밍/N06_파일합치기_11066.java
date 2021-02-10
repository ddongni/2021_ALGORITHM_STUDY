package N06_파일합치기_11066;

import java.util.Scanner;
/**
 * 점화식 세우는 연습
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[n+1];
			int[] sum = new int[n+1];
			for (int j = 1; j <= n; j++) {
				arr[j] = sc.nextInt();
				sum[j] = sum[j - 1] + arr[j];
			}
			int[][] dp = new int[n+1][n+1];
			for (int d = 1; d < n; d++) {
				for (int start = 1; start +d <= n; start++) {
					int end = start +d;
					dp[start][end] = Integer.MAX_VALUE;
					for (int mid = start; mid < end; mid++) {
						dp[start][end] = Math.min(dp[start][end], dp[start][mid] + dp[mid + 1][end]+sum[end]-sum[start-1]);
					}
				}
			}
			System.out.println(dp[1][n]);
		}
	}
}
