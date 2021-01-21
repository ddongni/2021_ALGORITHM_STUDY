package N12_스도쿠_2580;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

	static int[][] map = new int[9][9];
	static int[][] answer = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Deque<int[]> q = new LinkedList<>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 0) {
					q.addLast(new int[] { i, j });
				}
			}
		}
		put(q);
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(answer[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void put(Deque<int[]> q) {
		if (q.isEmpty()) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					answer[i][j] = map[i][j];
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
					put(q);
					map[x][y] = 0;
					q.addFirst(save);
				}
			}
		}
	}
}
