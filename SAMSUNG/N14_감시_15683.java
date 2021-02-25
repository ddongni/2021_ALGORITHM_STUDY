package N14_감시_15683;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 걸린 시간 : 42분 
 */
public class Main {
	static int[][][][] camera = { { { { 0, 1 } }, { { 0, -1 } }, { { 1, 0 } }, { { -1, 0 } } },
			{ { { 0, 1 }, { 0, -1 } }, { { -1, 0 }, { 1, 0 } } },
			{ { { -1, 0 }, { 0, 1 } }, { { -1, 0 }, { 0, -1 } }, { { 0, -1 }, { 1, 0 } }, { { 1, 0 }, { 0, 1 } } },
			{ { { -1, 0 }, { 0, -1 }, { 0, 1 } }, { { -1, 0 }, { 1, 0 }, { 0, 1 } }, { { 0, -1 }, { 0, 1 }, { 1, 0 } },
					{ { -1, 0 }, { 1, 0 }, { 0, -1 } } },
			{ { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } } } };
	static int answer=Integer.MAX_VALUE, sum=0;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		LinkedList<int[]> list = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0) {
					sum++;
					if (map[i][j] != 6) {
						list.add(new int[] { i, j, map[i][j] });
					}
				}
			}
		}
		start(n, m, map, list, 0, 0);
		System.out.println(answer);
	}

	static void start(int n, int m, int[][] map, LinkedList<int[]> li, int idx, int s) {
		if (idx == li.size()) {
			answer = Math.min(answer, n*m - sum -s);
			return;
		}
		int[] k = li.get(idx);
		int x = k[0], y = k[1], num = k[2];
		for (int i = 0; i < camera[num - 1].length; i++) {
			int count = 0;
			int[][] copy = new int[n][m];
			for (int a = 0; a < n; a++) {
				for (int b = 0; b < m; b++) {
					copy[a][b] = map[a][b];
				}
			}
			for (int j = 0; j < camera[num - 1][i].length; j++) {
				int nx = x, ny = y;
				while (true) {
					nx += camera[num - 1][i][j][0];
					ny += camera[num - 1][i][j][1];
					if (nx < 0 || ny < 0 || nx >= n || ny >= m || copy[nx][ny] == 6 ) {
						break;
					}
					if (copy[nx][ny] == 0) {
						copy[nx][ny] = 9;
						count++;
					}
				}
			}
			start(n, m, copy, li, idx + 1, s + count);
		}
	}
}
