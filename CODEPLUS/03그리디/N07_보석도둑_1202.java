package N07_보석도둑_1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(int[] a, int[] b) -> a[0] - b[0] == 0 ? b[1] - a[1] : a[0] - b[0]);
		StringTokenizer ST = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(ST.nextToken());
		int k = Integer.parseInt(ST.nextToken());
		for (int i = 0; i < n; i++) {
			ST = new StringTokenizer(br.readLine());
			pq.add(new int[] { Integer.parseInt(ST.nextToken()), Integer.parseInt(ST.nextToken()) });
		}
		PriorityQueue<Integer> bag = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			bag.add(Integer.parseInt(br.readLine()));
		}
		long answer = 0;
		PriorityQueue<int[]> top_p = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
		while (!bag.isEmpty()) {
			int bag_w = bag.poll();
			while (!pq.isEmpty()) {
				int[] x = pq.peek();
				if (x[0] <= bag_w) {
					top_p.add(new int[] { x[0], x[1] });
					pq.poll();
				} else {
					break;
				}
			}
			if (!top_p.isEmpty()) {
				int[] top = top_p.poll();
				answer += top[1];
			}
		}
		System.out.println(answer);
	}
}
