package N08_기타리스트_1495;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		boolean[][] dp = new boolean[n][m + 1];

		int first_dif = sc.nextInt();
		if (s + first_dif <= m) {
			dp[0][s + first_dif] = true;
		}
		if (s - first_dif >= 0) {
			dp[0][s - first_dif] = true;
		}
		for (int i = 1; i < n; i++) {
			int next = sc.nextInt();
			for (int j = 0; j <= m; j++) {
				if (!dp[i - 1][j])
					continue;
				if (j + next <= m) {
					dp[i][j + next] = true;
				}
				if (j - next >= 0) {
					dp[i][j - next] = true;
				}
			}
		}
		for (int i = m; i >= 0; i--) {
			if (dp[n - 1][i]) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(-1);
	}
}
