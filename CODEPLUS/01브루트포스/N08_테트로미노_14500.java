package N08_테트로미노_14500;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[][][] shape = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } },
				{ { 0, 0 }, { -1, 0 }, { -1, 1 }, { -1, 2 } }, { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 0, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { -2, 1 }, { -1, 1 }, { 0, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } }, { { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } },
				{ { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } }, { { 0, 0 }, { 1, -1 }, { 1, 0 }, { 2, -1 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } } };
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int answer = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				loop: for (int x = 0; x < 19; x++) {
					int sum = 0;
					for (int y = 0; y < 4; y++) {
						int nx = i + shape[x][y][0];
						int ny = j + shape[x][y][1];
						if (nx < 0 || ny < 0 || nx >= n || ny >= m)
							continue loop;
						sum += map[nx][ny];
					}
					answer = Math.max(answer, sum);
				}
			}
		}
		System.out.println(answer);
	}
}
