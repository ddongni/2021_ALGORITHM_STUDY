package N07_벽부수고이동하기2_14442;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, k, answer = Integer.MAX_VALUE;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int[][] map;
	static boolean[][][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		k = sc.nextInt();
		map = new int[n][m];
		check = new boolean[n][m][k+1];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		bfs();
		if (answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.println(answer);
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 1, 0 });
		check[0][0][0] = true;
		while (!q.isEmpty()) {
			int[] a = q.poll();
			if (a[0] == n - 1 && a[1] == m - 1) {
				answer = Math.min(answer, a[2]);
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nx = a[0] + r[i];
				int ny = a[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[nx][ny] == 1) {
					if (a[3] < k && !check[nx][ny][a[3]]) {
						check[nx][ny][a[3]] = true;
						q.add(new int[] { nx, ny, a[2] + 1, a[3] + 1 });
					}
				} else {
					if (!check[nx][ny][a[3]]) {
						check[nx][ny][a[3]] = true;
						q.add(new int[] { nx, ny, a[2] + 1, a[3] });
					}
				}
			}
		}
	}
}
