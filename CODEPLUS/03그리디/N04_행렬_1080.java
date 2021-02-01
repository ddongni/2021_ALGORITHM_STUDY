package N04_행렬_1080;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] a = new int[n * 2][m], b = new int[n][m];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				a[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < m; j++) {
				b[i][j] = str.charAt(j) - '0';
			}
		}
		int answer = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					if (i + 3 > n || j + 3 > m)
						continue;
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							if (b[i + k][j + l] == 1)
								b[i + k][j + l] = 0;
							else
								b[i + k][j + l] = 1;
						}
					}
					answer++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (a[i][j] != b[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(answer);
	}
}
