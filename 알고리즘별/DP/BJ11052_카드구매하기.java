package BJ11052_카드구매하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] dp = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; i * j <= n; j++) {
				dp[i * j] = Math.max(dp[i * j], arr[i] * j);
			}
			for (int j = 1; j < i && j + i <= n; j++) {
				dp[i + j] = Math.max(dp[i + j], dp[j] + dp[i]);
			}
		}
		System.out.println(dp[n]);
	}
}
/*
import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] d = new int[n+1];
		int[] p = new int[n+1];
		for(int i=1; i<=n; i++) {
			p[i] = sc.nextInt();
		}
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if(d[i]<d[i-j]+p[j])
					d[i] = d[i-j]+p[j];
			}
		}
		System.out.println(d[n]);
	}
}
*/
