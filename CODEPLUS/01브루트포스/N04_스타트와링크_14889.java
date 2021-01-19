package N04_스타트와링크_14889;

import java.util.Scanner;
/**
 * 디버깅 잘하기
 */
public class Main {
	static int[][] arr;
	static int n, answer = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int[] sel = new int[n / 2];
		select(sel, 0, 0, 0);
		System.out.println(answer);
	}

	static void select(int[] sel, int idx, int s, int k) {
		if (idx == n / 2) {
			int a = 0, b = 0;
			int[] sel2 = new int[n / 2];
			int idx2 = 0;
			for (int i = 0; i < n; i++) {
				if ((s & (1 << i)) == 0) {
					sel2[idx2] = i;
					idx2++;
				}
			}
			for (int i = 0; i < n / 2; i++) {
				for (int j = 0; j < n / 2; j++) {
					if (i == j)
						continue;
					a += arr[sel2[i]][sel2[j]];
					b += arr[sel[i]][sel[j]];
				}
			}
			answer = Math.min(answer, Math.abs(a - b));
			return;
		}
		for (int i = k; i < n; i++) {
			if ((s & (1 << i)) == 0) {
				sel[idx] = i;
				select(sel, idx + 1, s | (1 << i), i);
			}
		}
	}
}
