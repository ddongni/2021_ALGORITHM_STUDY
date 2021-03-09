package N01_LCA_11437;

import java.util.*;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer>[] li = new LinkedList[n + 1];
		for (int i = 0; i < n + 1; i++) {
			li[i] = new LinkedList<>();
		}
		for (int i = 0; i < n - 1; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			li[x].add(y);
			li[y].add(x);
		}

		int[] g = new int[n + 1];
		int[] p = new int[n + 1];
		boolean[] check = new boolean[n + 1];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 1, 0 });
		check[1] = true;

		while (!q.isEmpty()) {
			int[] k = q.poll();
			g[k[0]] = k[1]; // 세대 설정
			for (int x : li[k[0]]) {
				if (check[x])
					continue;
				check[x] = true;
				q.add(new int[] { x, k[1] + 1 });
				p[x] = k[0]; // 부모 설정
			}
		}

		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (g[a] < g[b]) {
				int diff = g[b] - g[a];
				while (diff-- > 0) {
					b = p[b];
				}
			} else if (g[a] > g[b]) {
				int diff = g[a] - g[b];
				while (diff-- > 0) {
					a = p[a];
				}
			}
			while (a != b) {
				a = p[a];
				b = p[b];
			}
			System.out.println(a);
		}
	}
}
