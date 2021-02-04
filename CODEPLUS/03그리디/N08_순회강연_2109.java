package N08_순회강연_2109;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		PriorityQueue<int[]> q = new PriorityQueue<>(
				(int[] a, int[] b) -> b[1] - a[1] == 0 ? b[0] - a[0] : b[1] - a[1]);
		for (int i = 0; i < n; i++) {
			int p = sc.nextInt();
			int d = sc.nextInt();
			q.add(new int[] { p, d });
		}
		PriorityQueue<int[]> select = new PriorityQueue<>((int[] a, int[] b) -> b[0] - a[0]);
		int day = q.peek()[1], ans = 0;
		while (day > 0) {
			while (!q.isEmpty()) {
				int[] k = q.peek();
				if (k[1] >= day) {
					select.add(k);
					q.poll();
				} else
					break;
			}
			if (!select.isEmpty()) {
				ans += select.poll()[0];
			}
			day--;
		}
		System.out.println(ans);
	}
}
