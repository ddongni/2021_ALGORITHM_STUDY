package N21_나무재테크_16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * 걸린 시간 : 1시간 19분
 */
public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] r = { -1, -1, -1, 0, 0, 1, 1, 1 }, c = { -1, 0, 1, -1, 1, -1, 0, 1 };
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long[][] map = new long[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = 5;
			}
		}
		int[][] arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> {
			return a[2] - b[2];
		});
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()) });
		}
		int time = 0;
		while (time++ < k) {
			Queue<int[]> new_pq = new LinkedList<>();
			Queue<int[]> dead = new LinkedList<>();
			while (!pq.isEmpty()) {
				int[] a = pq.poll();
				if (map[a[0]][a[1]] < a[2]) {
					dead.add(new int[] { a[0], a[1], a[2] });
				} else {
					map[a[0]][a[1]] -= a[2];
					new_pq.add(new int[] { a[0], a[1], a[2] + 1 });
				}
			}
			while (!dead.isEmpty()) {
				int[] a = dead.poll();
				map[a[0]][a[1]] += (a[2] / 2);
			}
			while (!new_pq.isEmpty()) {
				int[] a = new_pq.poll();
				if (a[2] % 5 == 0) {
					int sum = 0;
					for (int i = 0; i < 8; i++) {
						int nx = a[0] + r[i];
						int ny = a[1] + c[i];
						if (nx < 0 || ny < 0 || nx >= n || ny >= n)
							continue;
						pq.add(new int[] { nx, ny, 1 });
						sum++;
					}
				}
				pq.add(new int[] { a[0], a[1], a[2] });
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] += arr[i][j];
				}
			}
		}
		System.out.println(pq.size());
	}
}
