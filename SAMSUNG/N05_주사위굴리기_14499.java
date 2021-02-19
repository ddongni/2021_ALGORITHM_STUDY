package N05_주사위굴리기_14499;

import java.util.Scanner;
/**
 * 걸린 시간 : 31분 
 */
public class Main {
	static int[][] turn = { {}, { 0, 3, 2, 6, 1, 5, 4 }, { 0, 4, 2, 1, 6, 5, 3 }, { 0, 2, 6, 3, 4, 1, 5 },
			{ 0, 5, 1, 3, 4, 6, 2 } };
	static int[] r = { 0, 0, 0, -1, 1 }, c = { 0, 1, -1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int x = sc.nextInt();
		int y = sc.nextInt();
		int k = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int[] arr = new int[7];
		for (int i = 0; i < k; i++) {
			int d = sc.nextInt();
			x += r[d];
			y += c[d];
			if (x < 0 || y < 0 || x >= n || y >= m) {
				x -= r[d];
				y -= c[d];
				continue;
			}
			arr = move(d, arr);
			if (map[x][y] != 0) {
				arr[6] = map[x][y];
				map[x][y] = 0;
			} else {
				map[x][y] = arr[6];
			}
			System.out.println(arr[1]);
		}
	}

	static int[] move(int dir, int[] arr) {
		int[] new_arr = new int[7];
		for (int i = 1; i <= 6; i++) {
			new_arr[turn[dir][i]] = arr[i];
		}
		return new_arr;
	}
}
