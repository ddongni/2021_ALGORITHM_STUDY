package N02_데스나이트_16948;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	static int r1, c1, r2, c2, n;
	static int[][] map;
	static int[] r = { -2, -2, 0, 0, 2, 2 }, c = { -1, 1, -2, 2, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		bfs();
	}

	static void bfs() {
		PriorityQueue<info> q = new PriorityQueue<>();
		q.add(new info(r1, c1, 0));
		boolean[][] check = new boolean[n][n];
		while (!q.isEmpty()) {
			info k = q.poll();
			if (check[k.x][k.y])
				continue;
			check[k.x][k.y] = true;
			if(k.x==r2&&k.y==c2) {
				System.out.println(k.count);
				return;
			}
			for (int i = 0; i < 6; i++) {
				int nx = k.x + r[i];
				int ny = k.y + c[i];
				if (nx < 0 || ny < 0 || nx >= n || ny >= n)
					continue;
				q.add(new info(nx, ny, k.count + 1));
			}
		}
		System.out.println(-1);
		return;
	}
}

class info implements Comparable<info> {
	int x, y, count;

	info(int x, int y, int count) {
		this.x = x;
		this.y = y;
		this.count = count;
	}

	public int compareTo(info o) {
		return count - o.count;
	}
}
