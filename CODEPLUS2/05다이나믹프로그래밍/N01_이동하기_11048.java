package N01_이동하기_11048;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[][] ans = new int[n][m];
		ans[0][0] = map[0][0];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int up = 0, left = 0;
				if (i - 1 >= 0) {
					up = ans[i - 1][j];
				}
				if (j - 1 >= 0) {
					left = ans[i][j - 1];
				}
				ans[i][j] = Math.max(ans[i][j], map[i][j] + up);
				ans[i][j] = Math.max(ans[i][j], map[i][j] + left);
			}
		}
		System.out.println(ans[n - 1][m - 1]);
	}
}
