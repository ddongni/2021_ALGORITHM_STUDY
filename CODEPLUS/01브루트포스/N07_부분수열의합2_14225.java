package N07_부분수열의합2_14225;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int[] arr;
	static PriorityQueue<Integer> q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		q = new PriorityQueue<>();
		for (int i = 1; i <= n; i++) {
			int[] sel = new int[i];
			combi(sel, n, i, 0, 0);
		}
		int answer = 0;
		while (!q.isEmpty()) {
			int num = q.poll();
			if (num - answer > 1) {
				System.out.println(answer + 1);
				return;
			}
			answer = num;
		}
		System.out.println(answer + 1);
	}

	static void combi(int[] sel, int n, int r, int index, int target) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += arr[sel[i]];
			}
			q.add(sum);
			return;
		}
		if (target == n)
			return;
		sel[index] = target;
		combi(sel, n, r - 1, index + 1, target + 1);
		combi(sel, n, r, index, target + 1);
	}
}
