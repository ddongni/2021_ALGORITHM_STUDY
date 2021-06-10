package BJ1890_점프;

import java.util.Scanner;

public class Main {
	static int n, ans = 0;
	static int[] r = { 0, 1 }, c = { 1, 0 };
	static int[][] map;
	static long[][] dp;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		dp = new long[n][n];
		check = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		System.out.println(dfs(0, 0));
	}

	static long dfs(int x, int y) {
		if (x == n - 1 && y == n - 1) {
			return 1;
		}
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		check[x][y] = true;
		for (int i = 0; i < 2; i++) {
			int nx = x + map[x][y] * r[i];
			int ny = y + map[x][y] * c[i];
			if (nx >= 0 && ny >= 0 && nx < n && ny < n && !check[nx][ny]) {
				dp[x][y] += dfs(nx, ny);
			}
		}
		check[x][y] = false;
		return dp[x][y];
	}
}
