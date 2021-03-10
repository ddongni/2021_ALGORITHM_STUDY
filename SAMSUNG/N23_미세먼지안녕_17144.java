package N23_미세먼지안녕_17144;

import java.util.*;

/**
 * 걸린 시간 : 약 1시간 30분
 */
public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int[] R = { 0, 0, -1, 1 }, C = { -1, 1, 0, 0 };
		int r = sc.nextInt();
		int c = sc.nextInt();
		int t = sc.nextInt();
		int[][] map = new int[r][c];
		int[] filt = new int[2];
		int idx = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					filt[idx++] = i;
				} else if (map[i][j] != 0) {
					q.add(new int[] { i, j });
				}
			}
		}
		while (t-- > 0) {
			int[][] new_map = new int[r][c];

			new_map[filt[0]][0] = new_map[filt[1]][0] = -1;

			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (map[i][j] > 0) {
						int count = 0;
						for (int l = 0; l < 4; l++) {
							int nx = i + R[l];
							int ny = j + C[l];
							if (nx < 0 || ny < 0 || nx >= r || ny >= c || map[nx][ny] == -1)
								continue;
							new_map[nx][ny] += map[i][j] / 5;
							count++;
						}
						new_map[i][j] += (map[i][j] - (map[i][j] / 5) * count);
					}
				}
			}

			for (int i = 0; i < r; i++) {
				map[i] = new_map[i].clone();
			}
			int x1 = filt[0];
			int temp = 0;
			for (int i = 1; i < c; i++) {
				int temp2 = map[x1][i];
				map[x1][i] = temp;
				temp = temp2;
			}
			for (int i = x1 - 1; i >= 0; i--) {
				int temp2 = map[i][c - 1];
				map[i][c - 1] = temp;
				temp = temp2;
			}
			for (int i = c - 2; i >= 0; i--) {
				int temp2 = map[0][i];
				map[0][i] = temp;
				temp = temp2;
			}
			for (int i = 1; i < x1; i++) {
				int temp2 = map[i][0];
				map[i][0] = temp;
				temp = temp2;
			}

			int x2 = filt[1];
			temp = 0;
			for (int i = 1; i < c; i++) {
				int temp2 = map[x2][i];
				map[x2][i] = temp;
				temp = temp2;
			}
			for (int i = x2 + 1; i < r; i++) {
				int temp2 = map[i][c - 1];
				map[i][c - 1] = temp;
				temp = temp2;
			}
			for (int i = c - 2; i >= 0; i--) {
				int temp2 = map[r - 1][i];
				map[r - 1][i] = temp;
				temp = temp2;
			}
			for (int i = r - 2; i > x2; i--) {
				int temp2 = map[i][0];
				map[i][0] = temp;
				temp = temp2;
			}
		}
		int ans = 0;
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j] > 0)
					ans += map[i][j];
			}
		}
		System.out.println(ans);
	}
}
