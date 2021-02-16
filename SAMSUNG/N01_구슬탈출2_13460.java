package N01_구슬탈출2_13460;

import java.util.Scanner;

/**
 * 걸린 시간 : 1시간 51분
 * 주어진 조건에 잘 실행 되는 지 확인 
 */
public class Main {
	static char[][] map;
	static int rx, ry, bx, by, n, m;
	static int[] r = { 0, 0, -1, 1 }, c = { -1, 1, 0, 0 };
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				}
				if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		go(0, -1);
		if (answer == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(answer);
	}

	static void go(int count, int before) {
		if (count >= 10) {
			return;
		}
		char[][] copy = new char[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < 4; i++) {
			if (before == i)
				continue;
			int save_rx = rx;
			int save_ry = ry;
			int save_bx = bx;
			int save_by = by;
			if (i == 0) {
				if (ry < by)
					move_rfirst(i, count);
				else
					move_bfirst(i, count);
			} else if (i == 1) {
				if (ry > by)
					move_rfirst(i, count);
				else
					move_bfirst(i, count);
			} else if (i == 2) {
				if (rx < bx)
					move_rfirst(i, count);
				else
					move_bfirst(i, count);
			} else if (i == 3) {
				if (rx > bx)
					move_rfirst(i, count);
				else
					move_bfirst(i, count);
			}
			rx = save_rx;
			ry = save_ry;
			bx = save_bx;
			by = save_by;
			for (int l = 0; l < n; l++) {
				for (int j = 0; j < m; j++) {
					map[l][j] = copy[l][j];
				}
			}
		}
	}

	static void move_rfirst(int dir, int count) {
		boolean check_r = false;
		map[rx][ry] = '.';
		while (true) {
			rx += r[dir];
			ry += c[dir];
			if (map[rx][ry] == '#') {
				rx -= r[dir];
				ry -= c[dir];
				map[rx][ry] = 'R';
				break;
			}
			if (map[rx][ry] == 'O') {
				check_r = true;
				break;
			}
		}
		boolean check_b = false;
		map[bx][by] = '.';
		while (true) {
			bx += r[dir];
			by += c[dir];
			if (map[bx][by] == '#' || map[bx][by] == 'R') {
				bx -= r[dir];
				by -= c[dir];
				map[bx][by] = 'B';
				break;
			}
			if (map[bx][by] == 'O') {
				check_b = true;
				break;
			}
		}
		if (check_b) {
			return;
		}
		if (check_r) {
			answer = Math.min(answer, count+1);
			return;
		}
		go(count + 1, dir);
	}

	static void move_bfirst(int dir, int count) {
		boolean check_b = false;
		map[bx][by] = '.';
		while (true) {
			bx += r[dir];
			by += c[dir];
			if (map[bx][by] == '#') {
				bx -= r[dir];
				by -= c[dir];
				map[bx][by] = 'B';
				break;
			}
			if (map[bx][by] == 'O') {
				check_b = true;
				break;
			}
		}
		boolean check_r = false;
		map[rx][ry] = '.';
		while (true) {
			rx += r[dir];
			ry += c[dir];
			if (map[rx][ry] == '#' || map[rx][ry] == 'B') {
				rx -= r[dir];
				ry -= c[dir];
				map[rx][ry] = 'R';
				break;
			}
			if (map[rx][ry] == 'O') {
				check_r = true;
				break;
			}
		}
		if (check_b) {
			return;
		}
		if (check_r) {
			answer = Math.min(answer, count+1);
			return;
		}
		go(count + 1, dir);
	}
}
