package N05_로또_6603;

import java.util.Scanner;

public class Main {
	static int[] num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int k = sc.nextInt();
			if (k == 0)
				return;
			num = new int[k];
			for (int i = 0; i < k; i++) {
				num[i] = sc.nextInt();
			}
			int[] arr = new int[k];
			combi(arr, k, 6, 0, 0);
			System.out.println();
		}
	}

	static void combi(int[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			for (int i = 0; i < 6; i++) {
				System.out.print(num[arr[i]] + " ");
			}
			System.out.println();
			return;
		}
		if (target==n)
			return;
		arr[index] = target;
		combi(arr, n, r - 1, index + 1, target + 1);
		combi(arr, n, r, index, target + 1);
	}
}
