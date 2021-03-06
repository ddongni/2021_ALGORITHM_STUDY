package BJ9465_��ƼĿ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n];
			for (int i = 0; i < 2; i++) {
				StringTokenizer st =new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			dp[0][1] += dp[1][0];
			dp[1][1] += dp[0][0];
			
			int ans = Integer.MIN_VALUE;
			for (int i = 2; i < n; i++) {
				dp[0][i] += Math.max(dp[1][i - 1], dp[1][i - 2]);
				dp[1][i] += Math.max(dp[0][i - 1], dp[0][i - 2]);
				ans = Math.max(dp[0][i], dp[1][i]);
			}
			sb.append(ans+"\n");
		}
		System.out.println(sb.toString());
	}
}
