package N04_시험감독_13458;

import java.util.Scanner;

/**
 * 걸린 시간 : 18분 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int b = sc.nextInt();
		int c = sc.nextInt();
		long answer = n;
		for (int i = 0; i < n; i++) {
			arr[i] -= b;
			if (arr[i] < 0)
				continue;
			answer += (arr[i] / c);
			arr[i] -= (arr[i] / c) * c;
			if (arr[i] % c != 0)
				answer++;
		}
		System.out.println(answer);
	}
}
