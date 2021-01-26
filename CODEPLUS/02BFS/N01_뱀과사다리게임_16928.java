package N01_뱀과사다리게임_16928;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * visit 추가해서 효율 높임
 */
public class Main {
	static int[] move;
	static int answer =Integer.MAX_VALUE;

	public static void main(String[] args) {
		move = new int[101];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		for (int i = 0; i < n; i++) {
			move[sc.nextInt()]= sc.nextInt();
		}
		for (int j = 0; j < m; j++) {
			move[sc.nextInt()] = sc.nextInt();
		}
		bfs();
	}

	static void bfs() {
		PriorityQueue<info> pq = new PriorityQueue<>();
		if(move[1]!=0) {
			pq.add(new info(move[1], 0));			
		}else {
			pq.add(new info(1, 0));			
		}
		boolean[] visit = new boolean[101];
		while (!pq.isEmpty()) {
			info k = pq.poll();
			if(k.num==100) {
				System.out.println(k.count);
				return;
			}
			if(visit[k.num])
				continue;
			visit[k.num] = true;
			for (int i = 1; i <= 6; i++) {
				if (k.num + i > 100)
					continue;
				if (move[k.num + i] != 0) {
					pq.add(new info(move[k.num + i], k.count + 1));
					continue;
				}
				pq.add(new info(k.num + i, k.count + 1));
			}
		}
	}
}

class info implements Comparable<info> {
	int num, count;

	info(int num, int count) {
		this.num = num;
		this.count = count;
	}

	public int compareTo(info o) {
		if (count - o.count == 0) {
			return o.num - num;
		} else {
			return count - o.count;
		}
	}
}
