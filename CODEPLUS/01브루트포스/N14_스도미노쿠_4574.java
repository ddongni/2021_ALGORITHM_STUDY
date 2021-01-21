package N14_스도미노쿠_4574;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
/**
 * HashSet에서 int[] 사용 안됨
 */
public class Main {
	static int[][] map, answer;
	static int[] r = { -1, 1, 0, 0 }, c = { 0, 0, -1, 1 };
	static boolean[][] ck;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int index = 1;
		while (true) {
			n = sc.nextInt();
			if (n == 0) {
				break;
			}
			map = new int[9][9];
			answer = new int[9][9];
			ck = new boolean[9][9];
			HashSet<String> hs = new HashSet<>();
			for (int i = 0; i < n; i++) {
				int u = sc.nextInt();
				String str = sc.next();
				map[str.charAt(0) - 'A'][str.charAt(1) - '1'] = u;
				ck[str.charAt(0) - 'A'][str.charAt(1) - '1'] = true;
				int v = sc.nextInt();
				String str2 = sc.next();
				map[str2.charAt(0) - 'A'][str2.charAt(1) - '1'] = v;
				ck[str2.charAt(0) - 'A'][str2.charAt(1) - '1'] = true;
				if (u < v) {
					hs.add(""+u+""+v);
				} else {
					hs.add(""+v+""+u);
				}
			}
			for (int i = 1; i <= 9; i++) {
				String str3 = sc.next();
				map[str3.charAt(0) - 'A'][str3.charAt(1) - '1'] = i;
				ck[str3.charAt(0) - 'A'][str3.charAt(1) - '1'] = true;
			}
			Deque<int[]> q = new LinkedList<>();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (map[i][j] == 0) {
						q.addLast(new int[] { i, j });
					}
				}
			}
			put(q, hs);
			System.out.println("Puzzle " + index);
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(answer[i][j]);
				}
				System.out.println();
			}
			index++;
		}
	}

	static void check(HashSet<String> hs, int x, int y, int count) {
		if (hs.size() == 35) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					answer[i][j] = map[i][j];
				}
			}
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = x + r[i];
			int ny = y + c[i];
			if (nx < 0 || ny < 0 || nx >= 9 || ny >= 9 || ck[nx][ny])
				continue;

			HashSet<String> new_hs = new HashSet<>();
			for (String k : hs) {
				new_hs.add(k);
			}
			if (map[x][y] < map[nx][ny]) {
				boolean check = new_hs.add(""+map[x][y]+""+map[nx][ny]);
				if (!check) {
					continue;
				}
			} else {
				boolean check = new_hs.add(""+map[nx][ny]+""+map[x][y]);
				if (!check) {
					continue;
				}
			}
			ck[x][y] = true;
			ck[nx][ny] = true;
			loop: for (int l = 0; l < 9; l++) {
				for (int k = 0; k < 9; k++) {
					if (!ck[l][k]) {
						check(new_hs, l, k, count + 1);
						break loop;
					}
				}
			}
			ck[x][y] = false;
			ck[nx][ny] = false;
		}
	}

	static void put(Deque<int[]> q, HashSet<String> hs) {
		if (q.isEmpty()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (!ck[i][j]) {
						check(hs, i, j, 10);
						return;
					}
				}
			}
			return;
		}
		int[] next = q.peekFirst();
		int x = next[0];
		int y = next[1];
		int s = 0;
		for (int i = 0; i < 9; i++) {
			if (map[x][i] == 0)
				continue;
			s = s | (1 << map[x][i]);
		}
		int s3 = 0;
		for (int i = 0; i < 9; i++) {
			if (map[i][y] == 0)
				continue;
			s3 = s3 | (1 << map[i][y]);
		}

		for (int i = 1; i <= 9; i++) {
			if ((s & (1 << i)) == 0 && (s3 & (1 << i)) == 0) {
				int nx = x / 3 * 3;
				int ny = y / 3 * 3;
				int s2 = 0;
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if (map[nx + j][ny + k] == 0)
							continue;
						s2 = s2 | (1 << map[nx + j][ny + k]);
					}
				}
				if ((s2 & (1 << i)) == 0) {
					map[x][y] = i;
					int[] save = q.pollFirst();
					put(q, hs);
					map[x][y] = 0;
					q.addFirst(save);
				}
			}
		}
	}
}
