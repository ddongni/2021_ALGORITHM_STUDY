package N11_NQUEEN_9663;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int n, answer = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] queen = new int[n];
		Arrays.fill(queen, -1);
		put(queen, 0);
		System.out.println(answer);
	}

	static void put(int[] queen, int c) {
		if (c == n) {
			answer++;
			return;
		}
		for (int i = 0; i < n; i++) {
			boolean check = false;
			if (queen[i] != -1) {
				check = true;
			} else {
				for (int j = 0; j < n; j++) {
					if (queen[j] != -1) {
						if (Math.abs(c - queen[j]) == Math.abs(i - j))
							check = true;
					}
				}
			}
			if (!check) {
				queen[i] = c;
				put(queen, c + 1);
				queen[i] = -1;
			}
		}
	}
}
