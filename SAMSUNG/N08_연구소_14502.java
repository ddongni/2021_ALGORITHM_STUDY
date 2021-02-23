package N08_연구소_14502;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 걸린 시간 :37분
 */
public class Main {
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int n, m, answer = Integer.MIN_VALUE, SUM = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] map = new int[n][m];
		List<int[]> empty = new LinkedList<>();
		Queue<int[]> virus = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
				} else if (map[i][j] == 0) {
					empty.add(new int[] { i, j });
				} else {
					SUM++;
				}
			}
		}
		SUM += 3;
		put(map, virus, empty, 0, 0);
		System.out.println(answer);
	}

	static void put(int[][] map, Queue<int[]> virus, List<int[]> empty, int idx, int count) {
		if (count == 3) {
			bfs(map, virus);
			return;
		}
		for (int i = idx; i < empty.size(); i++) {
			int[] k = empty.get(i);
			map[k[0]][k[1]] = 1;
			put(map, virus, empty, i+ 1, count + 1);
			map[k[0]][k[1]] = 0;
		}
	}

	static void bfs(int[][] map, Queue<int[]> virus) {
		boolean[][] check = new boolean[n][m];
		int[][] copy = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
		int sum = 0;
		Queue<int[]> v = new LinkedList<>();
		for(int[] k : virus) {
			v.add(k);
		}
		while (!v.isEmpty()) {
			int[] k = v.poll();
			if (check[k[0]][k[1]])
				continue;
			check[k[0]][k[1]] = true;
			sum++;
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || copy[nx][ny] == 1)
					continue;
				copy[nx][ny] = 2;
				v.add(new int[] { nx, ny });
			}
		}
		answer = Math.max(answer, n * m - SUM - sum);
	}
}
