package N12_경사로_14890;

import java.util.Scanner;
/**
 * 걸린 시간 : 29분
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			boolean[] put = new boolean[n];
			int check = 1;
			for (int j = 0; j < n - 1; j++) {
				if (map[i][j + 1] - map[i][j] == 1) { // 왼쪽 검사
					for (int k = 0; k < l; k++) {
						if (j - k < 0) {
							check = 0;
							break;
						}
						if (map[i][j - k] != map[i][j]) {
							check = 0;
							break;
						}
						if (put[j - k]) {
							check = 0;
							break;
						}
						put[j - k] = true;
					}
					if (check == 0) {
						put = new boolean[n];
					}
				} else if (map[i][j + 1] - map[i][j] == -1) { // 오른쪽 검사
					for (int k = 1; k <= l; k++) {
						if (j + k >= n) {
							check = 0;
							break;
						}
						if (map[i][j + k] != map[i][j + 1]) {
							check = 0;
							break;
						}
						if (put[j + k]) {
							check = 0;
							break;
						}
						put[j + k] = true;
					}
				}
				if (Math.abs(map[i][j + 1] - map[i][j]) > 1) {
					check = 0;
				}
				if (check == 0)
					break;
			}
			if (check == 1) {
				count++;
			}
		}
		for (int j = 0; j < n; j++) {
			boolean[] put = new boolean[n];
			int check = 1;
			for (int i = 0; i < n - 1; i++) {
				if (map[i + 1][j] - map[i][j] == 1) { // 아래쪽 검사
					for (int k = 0; k < l; k++) {
						if (i - k < 0) {
							check = 0;
							break;
						}
						if (map[i - k][j] != map[i][j]) {
							check = 0;
							break;
						}
						if (put[i - k]) {
							check = 0;
							break;
						}
						put[i - k] = true;
					}
					if (check == 0) {
						put = new boolean[n];
					}
				} else if (map[i + 1][j] - map[i][j] == -1) { // 위쪽 검사
					for (int k = 1; k <= l; k++) {
						if (i + k >= n) {
							check = 0;
							break;
						}
						if (map[i + k][j] != map[i + 1][j]) {
							check = 0;
							break;
						}
						if (put[i + k]) {
							check = 0;
							break;
						}
						put[i + k] = true;
					}
				}
				if (Math.abs(map[i + 1][j] - map[i][j]) > 1) {
					check = 0;
				}
				if (check == 0)
					break;
			}
			if (check == 1) {
				count++;
			}
		}
		System.out.println(count);
	}
}
