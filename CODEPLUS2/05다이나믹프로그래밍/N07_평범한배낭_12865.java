package N07_평범한배낭_12865;

import java.util.Scanner;
/**
 * knapsack 알고리즘
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] arr = new int[n + 1][k + 1];
		for (int i = 1; i <= n; i++) {
			int w = sc.nextInt();
			int v = sc.nextInt();
			for (int j = 1; j <= k; j++) {
				if (j - w >= 0) {
					arr[i][j] = Math.max(arr[i - 1][j], arr[i - 1][j - w] + v);
				}else {
					arr[i][j] = arr[i - 1][j];
				}
			}
		}
		System.out.println(arr[n][k]);
	}
}
