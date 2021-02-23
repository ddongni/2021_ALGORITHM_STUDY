package N11_스타트와링크_14889;

import java.util.Scanner;
/**
 * 걸린 시간 : 53분 
 */
public class Main {
	static int ans = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] s = new int[n];
		sel(map, n, s, 0, 0);
		System.out.println(ans);
	}

	static void sel(int[][] map, int n, int[] s, int count, int idx) {
		if (count == n / 2) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						continue;
					if (s[i] == 1 && s[j] == 1) {
						sum1 += map[i][j];
					}
					if (s[i] == 0 && s[j] == 0) {
						sum2 += map[i][j];
					}
				}
			}
			ans = Math.min(ans, Math.abs(sum2 - sum1));
			return;
		}
		if (idx == n / 2)
			return;
		for (int i = idx; i < n; i++) {
			s[i]++;
			sel(map, n, s, count + 1, i + 1);
			s[i]--;
		}
	}
}
