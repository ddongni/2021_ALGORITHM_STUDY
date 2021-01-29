package N09_벽부수고이동하기4_16946;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;
/**
 * list 말고 배열 사용해서 시간 줄임
 */
public class Main {
	static int n, m;
	static int[][] map, copy;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		copy = new int[n][m];
		check = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - '0';
				if (map[i][j] == 1) {
					check[i][j] = true;
				}
			}
		}
		int[] count_list = new int[1000000];
		int idx = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!check[i][j]) {
					int count = bfs(i, j, idx);
					count_list[idx] = count;
					idx++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					Set<Integer> s = new HashSet<>();
					for (int l = 0; l < 4; l++) {
						int nx = i + r[l];
						int ny = j + c[l];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m || copy[nx][ny] == 0)
							continue;
						s.add(copy[nx][ny]);
					}
					for (int x : s) {
						map[i][j] += count_list[x];
					}
					map[i][j] %= 10;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	static int bfs(int x, int y, int idx) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { x, y });
		check[x][y] = true;
		copy[x][y] = idx;
		int count = 1;
		while (!q.isEmpty()) {
			int[] k = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = k[0] + r[i];
				int ny = k[1] + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= m)
					continue;
				if (map[nx][ny] == 0) {
					if (!check[nx][ny]) {
						check[nx][ny] = true;
						q.add(new int[] { nx, ny });
						copy[nx][ny] = idx;
						count++;
					}
				}
			}
		}
		return count;
	}
}
