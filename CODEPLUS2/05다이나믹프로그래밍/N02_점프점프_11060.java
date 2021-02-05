package N02_점프점프_11060;

import java.util.Scanner;
/**
 * 조건 확인
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		if (n == 1) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (dp[i] == 0 && i != 0)
				continue;
			for (int j = arr[i]; j > 0; j--) {
				if (i + j >= n)
					continue;
				if (dp[i + j] == 0) {
					dp[i + j] = dp[i] + 1;
				} else {
					dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
				}
			}
		}
		if (dp[n - 1] == 0)
			System.out.println(-1);
		else
			System.out.println(dp[n - 1]);
	}
}
