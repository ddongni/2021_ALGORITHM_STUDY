package N06_부분수열의합_1182;

import java.util.Scanner;

public class Main {
	static int[] arr;
	static int answer = 0, s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			int[] Arr = new int[i];
			combi(Arr, n, i, 0, 0);
		}
		System.out.println(answer);
	}

	static void combi(int[] Arr, int n, int r, int index, int target) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < Arr.length; i++) {
				sum += arr[Arr[i]];
			}
			if (sum == s) {
				answer++;
			}
			return;
		}
		if (target == n)
			return;
		Arr[index] = target;
		combi(Arr, n, r - 1, index + 1, target + 1);
		combi(Arr, n, r, index, target + 1);
	}
}
