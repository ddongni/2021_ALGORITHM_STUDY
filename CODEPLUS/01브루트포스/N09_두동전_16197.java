package N09_두동전_16197;

import java.util.Scanner;

public class Main {
	static int[][] coin = new int[2][2];
	static int[] r = { 0, 0, -1, 1 }, c = { -1, 1, 0, 0 };
	static int n, m, answer = Integer.MAX_VALUE;
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		int idx = 0;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'o') {
					coin[idx][0] = i;
					coin[idx][1] = j;
					idx++;
				}
			}
		}
		move(1);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static void move(int count) {
		if (count > 10) {
			return;
		}
		int cx1 = coin[0][0];
		int cy1 = coin[0][1];
		int cx2 = coin[1][0];
		int cy2 = coin[1][1];
		for (int i = 0; i < 4; i++) {
			int nx1 = cx1 + r[i];
			int ny1 = cy1 + c[i];
			int nx2 = cx2 + r[i];
			int ny2 = cy2 + c[i];
			boolean check1 = false, check2 = false;
			if (nx1 < 0 || ny1 < 0 || nx1 >= n || ny1 >= m) {
				check1 = true;
			}
			if (nx2 < 0 || ny2 < 0 || nx2 >= n || ny2 >= m) {
				check2 = true;
			}
			if (check1 && !check2) {
				answer = Math.min(answer, count);
				return;
			} else if (!check1 && check2) {
				answer = Math.min(answer, count);
				return;
			}
			if (check1 && check2)
				continue;
			if (map[nx1][ny1] != '#') {
				coin[0][0] = nx1;
				coin[0][1] = ny1;
			}
			if (map[nx2][ny2] != '#') {
				coin[1][0] = nx2;
				coin[1][1] = ny2;
			}
			move(count + 1);
			if (map[nx1][ny1] != '#') {
				coin[0][0] = cx1;
				coin[0][1] = cy1;
			}
			if (map[nx2][ny2] != '#') {
				coin[1][0] = cx2;
				coin[1][1] = cy2;
			}
		}

	}
}
