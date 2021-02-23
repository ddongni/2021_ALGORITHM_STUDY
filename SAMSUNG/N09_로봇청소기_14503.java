package N09_로봇청소기_14503;

import java.util.Scanner;
/**
 * 걸린 시간 : 34분 
 */
public class Main {
	static int[] r = { -1, 0, 1, 0 }, c = { 0, 1, 0, -1 };
	static int[] turn = { 3, 0, 1, 2 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		int d = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		map[R][C] = 9;
		int answer = 1;
		while (true) {
			int count = 0;
			for (int i = 0; i < 4; i++) {
				d = turn[d];
				int nx = R + r[d];
				int ny = C + c[d];
				if (map[nx][ny] == 1 || map[nx][ny] == 9) {
					count++;
					continue;
				}
				R = nx;
				C = ny;
				answer++;
				break;
			}
			if (count == 4) {
				if (map[R - r[d]][C - c[d]] == 1) {
					break;
				} else {
					R -= r[d];
					C -= c[d];
					continue;
				}
			}
			map[R][C] = 9;
		}
		System.out.println(answer);
	}
}
