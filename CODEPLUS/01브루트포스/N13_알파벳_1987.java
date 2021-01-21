package N13_알파벳_1987;

import java.util.Scanner;
/**
 * 백트래킹 주의
 */
public class Main {
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static int R, C, answer = Integer.MIN_VALUE;
	static boolean[] alpha = new boolean[26];
	static boolean[][] check;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		move(0, 0, 1);
		System.out.println(answer);
	}

	static void move(int x, int y, int count) {
		alpha[map[x][y] - 'A'] = true;
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + r[i];
			int ny = y + c[i];
			if (nx < 0 || ny < 0 || nx >= R || ny >= C || check[nx][ny])
				continue;
			if (!alpha[map[nx][ny] - 'A']) {
				move(nx, ny, count + 1);
			}
		}
		answer = Math.max(answer, count);
		alpha[map[x][y] - 'A'] = false;
		check[x][y] = false;
	}
}
