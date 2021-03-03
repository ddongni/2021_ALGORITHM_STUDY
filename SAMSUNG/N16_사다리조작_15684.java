package N16_사다리조작_15684;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 걸린 시간 : 1시간 13분
 * 시간 초과 문제로 시간 걸림
 */
public class Main {
	static List<int[]> li;
	static int n, h, answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		h = sc.nextInt();
		int[][] map = new int[h + 1][n + 1];
		for (int i = 0; i < m; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			map[x][y] = 9;
			if (y - 1 > 0)
				map[x][y - 1] = 1;
			if (y + 1 < n)
				map[x][y + 1] = 1;
		}
		li = new LinkedList<>();
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j < n; j++) {
				if (map[i][j] == 0) {
					li.add(new int[] { i, j });
				}
			}
		}
		put(0, 0, map);
		System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
	}

	static void put(int idx, int count, int[][] map) {
		if (check(map)) {
			answer = Math.min(answer, count);
			return;
		}
		if (count == 3)
			return;
		if (answer <= count)
			return;
		for (int i = idx; i < li.size(); i++) {
			int[][] copy = new int[h + 1][n + 1];
			for (int j = 0; j < h + 1; j++) {
				copy[j] = map[j].clone();
			}
			int[] k = li.get(i);
			if (copy[k[0]][k[1]] == 0) {
				copy[k[0]][k[1]] = 9;
				if (k[1] - 1 > 0 && copy[k[0]][k[1] - 1] == 0)
					copy[k[0]][k[1] - 1] = 1;
				if (k[1] + 1 < n && map[k[0]][k[1] + 1] == 0)
					copy[k[0]][k[1] + 1] = 1;
				put(i + 1, count + 1, copy);
			}
		}
	}

	static boolean check(int[][] map) {
		for (int i = 0; i < n; i++) {
			int r = 1, c = i;
			while (r <= h) {
				if (c - 1 >= 0 && map[r][c] == 9) {
					c--;
				} else if (c + 1 < n && map[r][c + 1] == 9) {
					c++;
				}
				r++;
			}
			if (c != i) {
				return false;
			}
		}
		return true;
	}
}
