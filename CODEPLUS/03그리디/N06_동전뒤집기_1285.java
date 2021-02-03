package N06_동전뒤집기_1285;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] map = new char[n][n];
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		int answer = Integer.MAX_VALUE;
		for (int i = 0; i < (1 << n); i++) {
			int min = 0;
			for (int y = 0; y < n; y++) {
				int sum = 0;
				for (int x = 0; x < n; x++) { // 행 뒤집기
					char ch = map[x][y];
					if (((1 << x) & i) != 0) {
						if (ch == 'T')
							ch = 'H';
						else
							ch = 'T';
					}
					if (ch == 'T')
						sum++;
				}
				min += Math.min(sum, n - sum); // 열 뒤집는 것과 비교
			}
			answer = Math.min(answer, min);
		}
		System.out.println(answer);
	}
}
