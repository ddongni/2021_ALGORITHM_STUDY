package BJ1912_¿¬¼ÓÇÕ;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int ans = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			sum = num > sum + num ? num : sum + num;
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}
