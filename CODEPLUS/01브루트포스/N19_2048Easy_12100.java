package N19_2048Easy_12100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 비트마스크 사용x
 */
public class Main {
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		move(map, 0);
		System.out.println(answer);
	}

	static void move(int[][] map, int count) {
		if (count == 5) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int[][] copy = new int[n][n];
			if (i == 0) {
				for (int l = 0; l < n; l++) {
					Queue<Integer> q = new LinkedList<>();
					for (int j = 0; j < n; j++) {
						if (map[j][l] == 0)
							continue;
						q.add(map[j][l]);
					}
					int idx = 0;
					while (!q.isEmpty()) {
						int x = q.poll();
						if (q.isEmpty()) {
							copy[idx][l] = x;
							answer = Math.max(answer, copy[idx][l]);
							break;
						}
						int y = q.peek();
						if (x == y) {
							copy[idx][l] = 2 * x;
							answer = Math.max(answer, copy[idx][l]);
							q.poll();
						} else {
							copy[idx][l] = x;
							answer = Math.max(answer, copy[idx][l]);
						}
						idx++;
					}
				}
			} else if (i == 1) {
				for (int l = 0; l < n; l++) {
					Queue<Integer> q = new LinkedList<>();
					for (int j = n - 1; j >= 0; j--) {
						if (map[j][l] == 0)
							continue;
						q.add(map[j][l]);
					}
					int idx = n - 1;
					while (!q.isEmpty()) {
						int x = q.poll();
						if (q.isEmpty()) {
							copy[idx][l] = x;
							answer = Math.max(answer, copy[idx][l]);
							break;
						}
						int y = q.peek();
						if (x == y) {
							copy[idx][l] = 2 * x;
							answer = Math.max(answer, copy[idx][l]);
							q.poll();
						} else {
							copy[idx][l] = x;
							answer = Math.max(answer, copy[idx][l]);
						}
						idx--;
					}
				}
			} else if (i == 2) {
				for (int l = 0; l < n; l++) {
					Queue<Integer> q = new LinkedList<>();
					for (int j = 0; j < n; j++) {
						if (map[l][j] == 0)
							continue;
						q.add(map[l][j]);
					}
					int idx = 0;
					while (!q.isEmpty()) {
						int x = q.poll();
						if (q.isEmpty()) {
							copy[l][idx] = x;
							answer = Math.max(answer, copy[l][idx]);
							break;
						}
						int y = q.peek();
						if (x == y) {
							copy[l][idx] = 2 * x;
							answer = Math.max(answer, copy[l][idx]);
							q.poll();
						} else {
							copy[l][idx] = x;
							answer = Math.max(answer, copy[l][idx]);
						}
						idx++;
					}
				}
			} else {
				for (int l = 0; l < n; l++) {
					Queue<Integer> q = new LinkedList<>();
					for (int j = n - 1; j >= 0; j--) {
						if (map[l][j] == 0)
							continue;
						q.add(map[l][j]);
					}
					int idx = n - 1;
					while (!q.isEmpty()) {
						int x = q.poll();
						if (q.isEmpty()) {
							copy[l][idx] = x;
							answer = Math.max(answer, copy[l][idx]);
							break;
						}
						int y = q.peek();
						if (x == y) {
							copy[l][idx] = 2 * x;
							answer = Math.max(answer, copy[l][idx]);
							q.poll();
						} else {
							copy[l][idx] = x;
							answer = Math.max(answer, copy[l][idx]);
						}
						idx--;
					}
				}
			}
			move(copy, count + 1);
		}
	}
}
