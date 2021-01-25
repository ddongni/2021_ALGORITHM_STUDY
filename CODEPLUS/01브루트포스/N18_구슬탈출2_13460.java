package N18_구슬탈출2_13460;

import java.util.Scanner;
/**
 * 비트마스크 이용x
 */
class Main {
	static int n, m, answer = Integer.MAX_VALUE;
	static int[] r = { 0, 0, 1, -1 }, c = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		char[][] map = new char[n][m];
		int rx = 0, ry = 0, bx = 0, by = 0;
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
				if (map[i][j] == 'R') {
					rx = i;
					ry = j;
				} else if (map[i][j] == 'B') {
					bx = i;
					by = j;
				}
			}
		}
		select(map, rx, ry, bx, by, -1, 1);
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}
	}

	static void select(char[][] map, int rx, int ry, int bx, int by, int dir, int count) {
		if (count > 10) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (i == dir)
				continue;
			char[][] copy = new char[n][m];
			for (int l = 0; l < n; l++) {
				for (int j = 0; j < m; j++) {
					copy[l][j] = map[l][j];
				}
			}
			if (i == 0) {// 왼족
				if (ry < by) {
					go_rfirst(copy, rx, ry, bx, by, i, count);
				} else {
					go_bfirst(copy, rx, ry, bx, by, i, count);
				}
			} else if (i == 1) { // 오른쪽
				if (ry < by) {
					go_bfirst(copy, rx, ry, bx, by, i, count);
				} else {
					go_rfirst(copy, rx, ry, bx, by, i, count);
				}
			} else if (i == 2) { // 아래쪽
				if (rx < bx) {
					go_bfirst(copy, rx, ry, bx, by, i, count);
				} else {
					go_rfirst(copy, rx, ry, bx, by, i, count);
				}
			} else if (i == 3) {// 위쪽
				if (rx < bx) {
					go_rfirst(copy, rx, ry, bx, by, i, count);
				} else {
					go_bfirst(copy, rx, ry, bx, by, i, count);
				}
			}
		}
	}

	static void go_rfirst(char[][] copy, int rx, int ry, int bx, int by, int dir, int count) {
		boolean red = false, blue = false;

		copy[rx][ry] = '.';
		info rk = move(copy, rx, ry, dir);

		if (copy[rk.x][rk.y] == 'O') {
			red = true;
		} else {
			copy[rk.x][rk.y] = 'R';
		}
		copy[bx][by] = '.';
		info bk = move(copy, bx, by, dir);

		if (copy[bk.x][bk.y] == 'O') {
			blue = true;
		} else if (copy[bk.x][bk.y] == 'R') {
			bk.x -= r[dir];
			bk.y -= c[dir];
			copy[bk.x][bk.y] = 'B';
		} else {
			copy[bk.x][bk.y] = 'B';
		}

		if (red && !blue) {
			answer = Math.min(answer, count);
			return;
		} else if (!red && !blue) {
			select(copy, rk.x, rk.y, bk.x, bk.y, dir, count + 1);
		} else {
			return;
		}
	}

	static void go_bfirst(char[][] copy, int rx, int ry, int bx, int by, int dir, int count) {
		boolean red = false, blue = false;

		copy[bx][by] = '.';
		info bk = move(copy, bx, by, dir);

		if (copy[bk.x][bk.y] == 'O') {
			blue = true;
		} else {
			copy[bk.x][bk.y] = 'B';
		}
		copy[rx][ry] = '.';
		info rk = move(copy, rx, ry, dir);

		if (copy[rk.x][rk.y] == 'O') {
			red = true;
		} else if (copy[rk.x][rk.y] == 'B') {
			rk.x -= r[dir];
			rk.y -= c[dir];
			copy[rk.x][rk.y] = 'R';
		} else {
			copy[rk.x][rk.y] = 'R';
		}

		if (red && !blue) {
			answer = Math.min(answer, count);
			return;
		} else if (!red && !blue) {
			select(copy, rk.x, rk.y, bk.x, bk.y, dir, count + 1);
		} else {
			return;
		}
	}

	static info move(char[][] copy, int x, int y, int dir) {
		while (true) {
			x += r[dir];
			y += c[dir];
			if (copy[x][y] == '#') {
				x -= r[dir];
				y -= c[dir];
				break;
			}
			if (copy[x][y] == 'O') {
				break;
			}
		}
		return new info(x, y, copy[x][y]);
	}
}

class info {
	int x, y;
	char ch;

	info(int x, int y, char ch) {
		this.x = x;
		this.y = y;
		this.ch = ch;
	}
}
