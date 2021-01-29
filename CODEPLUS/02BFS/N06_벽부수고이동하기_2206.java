package N06_벽부수고이동하기_2206;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * bfs 방문처리 새로운 유형
 */
public class Main {
	static Queue<int[]> wall;
	static int[][] map;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int n, m;
	static boolean[][][] check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		wall = new LinkedList<>();
		check = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1) {
					wall.add(new int[] { i, j });
				}
			}
		}
		bfs();
	}

	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0, 1, 0 });
		check[0][0][0] = true;
		map[0][0] = 1;
		while (!q.isEmpty()) {
			int[] x = q.poll();
			if (x[0] == n - 1 && x[1] == m - 1) {
				System.out.println(x[2]);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int nx = x[0] + r[i];
				int ny = x[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				//새로운 위치 1 일 때
				if (map[nx][ny] == 1) {
					if (x[3] == 0 && !check[nx][ny][1]) {
						//새로운 위치 nx, ny의 벽 부수고 온 애 true
						check[nx][ny][1] = true;
						q.add(new int[] { nx, ny, x[2] + 1, x[3] + 1 });
					}
					continue;
				}
				//새로운 위치 0 일 때
				if (!check[nx][ny][x[3]]) { 
					//새로운 위치 nx ny에 벽을 부수고 오든 안오든 true
					check[nx][ny][x[3]] = true;
					q.add(new int[] { nx, ny, x[2] + 1, x[3] });
				}
			}
		}
		System.out.println(-1);
	}
}
