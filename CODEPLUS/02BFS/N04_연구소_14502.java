package N04_연구소_14502;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int n, m, answer = Integer.MIN_VALUE, ans;
	static List<int[]> none;
	static Queue<int[]> virus;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ans = n * m - 3;
		none = new LinkedList<>();
		virus = new LinkedList<>();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					none.add(new int[] { i, j });
				} else if (map[i][j] == 2) {
					virus.add(new int[] { i, j });
					ans--;
				} else {
					ans--;
				}
			}
		}
		boolean[] check = new boolean[none.size()];
		wall(map, check, 0);
		System.out.println(answer);
	}

	static void wall(int[][] map, boolean[] check, int count) {
		if (count == 3) {
			
			 bfs(map);
			return;
		}
		for (int i = 0; i < none.size(); i++) {
			if (check[i])
				continue;
			int[] k = none.get(i);
			map[k[0]][k[1]] = 1;
			check[i] = true;
			wall(map, check, count + 1);
			check[i] = false;
			map[k[0]][k[1]] = 0;
		}
	}

	static void bfs(int[][] map) {
		int count = 0;
		Queue<int[]> copy = new LinkedList<>();
		for (int[] k : virus) {
			copy.add(new int[] { k[0], k[1] });
		}
		int[][] copy_m = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy_m[i][j] = map[i][j];
			}
		}
		while (!copy.isEmpty()) {
			int[] k = copy.poll();
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m || copy_m[nx][ny] == 1 || copy_m[nx][ny] == 2)
					continue;
				copy.add(new int[] { nx, ny });
				copy_m[nx][ny] = 2;
				count++;
			}
		}
		answer = Math.max(answer, ans - count);

	}
}
