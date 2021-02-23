package N06_테트로미노_14500;

import java.util.Scanner;

/**
 * 걸린 시간 : 17분 
 */
public class Main {
	public static void main(String[] args) {
		int[][][] block = { { { 0, 0 }, { 1, 0 }, { 2, 0 }, { 3, 0 } },{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 0, 3 } }, { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 0 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 2 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 0 } }, { { 0, 0 }, { 0, 1 }, { -1, 1 }, { 1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 0, 2 }, { 1, 1 } }, { { 0, 0 }, { 0, 1 }, { 0, 2 }, { -1, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 2, 0 }, { 2, 1 } }, { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 2, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 0 }, { 2, 0 } }, { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -2, 1 } },
				{ { 0, 0 }, { 1, 0 }, { 1, 1 }, { 2, 1 } }, { { 0, 0 }, { 1, 0 }, { 0, 1 }, { -1, 1 } },
				{ { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 2 } }, { { 0, 0 }, { 0, 1 }, { -1, 1 }, { -1, 2 } } };

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
				loop: for (int k = 0; k < 19; k++) {
					int sum = 0;
					for (int l = 0; l < 4; l++) {
						int nx = i + block[k][l][0];
						int ny = j + block[k][l][1];
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
