package BJ9507_GenerationsofTribbles;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		long[] dp = new long[68];
		long[] ans = new long[68];
		ans[0] = ans[1] = 1;
		ans[2] = 2;
		ans[3] = 4;
		int sum = 0;
		for (int i = 0; i <= 3; i++) {
			sum += ans[i];
			dp[i] = sum;
		}
		dp[4] = dp[3] * 2;
		ans[4] = dp[3];
		for (int i = 5; i < 68; i++) {
			ans[i] = dp[i - 1] - dp[i - 5];
			dp[i] = dp[i - 1] + ans[i];
		}
		while (t-- > 0) {
			System.out.println(ans[sc.nextInt()]);
		}
	}
}
/*
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		BigInteger[] map = new BigInteger[68];
		map[0]=BigInteger.valueOf(1);
		map[1]=BigInteger.valueOf(1);
		map[2]=BigInteger.valueOf(2);
		map[3]=BigInteger.valueOf(4);
		for(int i=4;i<68;i++) {
			map[i] = map[i-1].add(map[i-2]).add(map[i-3]).add(map[i-4]);
		}
		while(t>0) {
			int a = sc.nextInt();
			System.out.println(map[a]);
			t--;
		}
	}
}
*/
