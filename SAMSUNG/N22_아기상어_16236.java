package N22_아기상어_16236;

import java.util.*;
/**
 * 걸린 시간 : 약 2시간 
 */
class Main {
	static int[] r = { -1, 0, 0, 1 }, c = { 0, -1, 1, 0 };
	static int ans = 0, n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		int shark = 2;

		int sharkx = 0, sharky = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 9) {
					sharkx = i;
					sharky = j;
				}
			}
		}
		move(sharkx, sharky, shark, map, 0, 0);
		System.out.println(ans);
	}

	static void move(int x, int y, int shark, int[][] map, int count, int time) {
		if (count == shark) {
			shark++;
			count = 0;
		}
		map[x][y] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
			return (a[2] - b[2]) == 0 ? (a[0] - b[0] == 0 ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2];
		});
		PriorityQueue<int[]> q = new PriorityQueue<>((int[] a, int[] b) -> {
			return a[2] - b[2];
		});

		q.add(new int[] { x, y, 0 });
		boolean[][] check = new boolean[n][n];
		check[x][y] = true;
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			if (k[2] > min) {
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n || check[nx][ny] || map[nx][ny] > shark)
					continue;

				check[nx][ny] = true;
				q.add(new int[] { nx, ny, k[2] + 1 });
				if (map[nx][ny] == 0)
					continue;
				if (map[nx][ny] < shark) {
					pq.add(new int[] { nx, ny, k[2] + 1 });
					min = Math.min(min, k[2] + 1);
				}
			}
		}
		if (pq.isEmpty()) {
			ans = time;
			return;
		}

		int[] k = pq.poll();
		move(k[0], k[1], shark, map, count + 1, time + min);

	}
}
