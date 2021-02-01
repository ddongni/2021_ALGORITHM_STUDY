package N02_회의실배정_1931;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(int[] a, int[] b) -> a[1] - b[1] == 0 ? a[0] - b[0] : a[1] - b[1]);
		for (int i = 0; i < n; i++) {
			pq.add(new int[] { sc.nextInt(), sc.nextInt() });
		}
		int answer = 0, end = -1;
		while (!pq.isEmpty()) {
			int[] k = pq.poll();
			if (k[0] >= end) {
				end = k[1];
				answer++;
			}
		}
		System.out.println(answer);
	}
}
