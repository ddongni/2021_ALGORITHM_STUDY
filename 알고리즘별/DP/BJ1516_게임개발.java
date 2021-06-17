package BJ1516_게임개발;

import java.util.*;

public class Main {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] linked = new LinkedList[n + 1];
		int[] countParent = new int[n + 1];
		int[] time = new int[n + 1];
		int[] dp = new int[n + 1];
		Queue<Integer> parentNode = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			linked[i] = new LinkedList<>();
		}
		for (int i = 1; i <= n; i++) {
			time[i] = sc.nextInt();
			while (true) {
				int num = sc.nextInt();
				if (num == -1)
					break;
				linked[num].add(i);
				countParent[i]++;

			}
			if (countParent[i] == 0) {
				parentNode.add(i);
				dp[i] = time[i];
			}
		}
		while (!parentNode.isEmpty()) {
			int parent = parentNode.poll();
			for (int child : linked[parent]) {
				dp[child] = Math.max(dp[child], dp[parent] + time[child]);
				countParent[child]--;
				if (countParent[child] == 0) {
					parentNode.add(child);
				}
			}
		}
		for (int i = 1; i <= n; i++) {
			System.out.println(dp[i]);
		}
	}
}
