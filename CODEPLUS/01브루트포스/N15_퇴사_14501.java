package N15_퇴사_14501;

import java.util.Scanner;
/**
 * 다익스트라로 푸는 방법도 있음
 */
public class Main {
	static int[][] pro;
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		pro = new int[n][2];
		for (int i = 0; i < n; i++) {
			pro[i][0] = sc.nextInt();
			pro[i][1] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			select(i, 0);
		}
		System.out.println(answer);
	}

	static void select(int day, int sum) {
		for (int i = day; i < n; i++) {
			int next = i + pro[i][0];
			if (next > n) {
				answer = Math.max(answer, sum);
			} else if (next < n) {
				select(next, sum + pro[i][1]);
			} else {
				answer = Math.max(answer, sum + pro[i][1]);
			}
		}
	}
}
