package N20_인구이동_16234;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * 걸린 시간 : 51분 
 */
public class Main {
	static int[][] map;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int n, L, R;
	static boolean[][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		L = sc.nextInt();
		R = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer = 0;
		while (true) {
			check = new boolean[n][n];
			boolean end = true;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!check[i][j]) {
						if (!div(i, j, true)) {
							end = false;
						}
					}
				}
			}
			if (end)
				break;
			else
				answer++;
		}
		System.out.println(answer);
	}

	static boolean div(int x, int y, boolean ans) {
		Queue<int[]> q = new LinkedList<>();
		List<int[]> li = new LinkedList<>();
		q.add(new int[] { x, y });
		int sum = 0;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			if (check[k[0]][k[1]])
				continue;
			check[k[0]][k[1]] = true;
			sum += map[k[0]][k[1]];
			li.add(new int[] { k[0], k[1] });
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				int diff = Math.abs(map[k[0]][k[1]] - map[nx][ny]);
				if (diff >= L && diff <= R) {
					q.add(new int[] { nx, ny });
					ans = false;
				}
			}
		}
		if (!ans) {
			for (int i = 0; i < li.size(); i++) {
				int[] k = li.get(i);
				map[k[0]][k[1]] = sum / li.size();
			}
		}
		return ans;
	}
}
