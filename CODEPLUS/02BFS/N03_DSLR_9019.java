package N03_DSLR_9019;

import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 *	o(n) 복잡도 -> o(1)로 구할 수 있는지 확인
 */
public class Main {
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sb = new StringBuilder();
		while (t-- > 0) {
			bfs(sc.nextInt(), sc.nextInt());
		}
		System.out.println(sb.toString());
	}

	static void bfs(int a, int b) {
		PriorityQueue<info> q = new PriorityQueue<>();
		boolean[] check = new boolean[10000];
		q.add(new info("", a));
		check[a] = true;
		while (!q.isEmpty()) {
			info k = q.poll();
			if (k.num == b) {
				sb.append(k.result + "\n");
				return;
			}
			// D
			int new_num = k.num * 2;
			if (new_num > 9999)
				new_num %= 10000;
			if (!check[new_num]) {
				q.add(new info(k.result + "D", new_num));
				check[new_num] = true;
			}
			// S
			if (k.num == 0) {
				new_num = 9999;
			} else {
				new_num = k.num - 1;
			}
			if (!check[new_num]) {
				q.add(new info(k.result + "S", new_num));
				check[new_num] = true;
			}
			// L
			new_num = (k.num % 1000) * 10 + (k.num / 1000);
			if (!check[new_num]) {
				q.add(new info(k.result + "L", new_num));
				check[new_num] = true;
			}
			// R
			new_num = (k.num / 10) + (k.num % 10) * 1000;
			if (!check[new_num]) {
				q.add(new info(k.result + "R", new_num));
				check[new_num] = true;
			}
		}
	}
}

class info implements Comparable<info> {
	String result;
	int num;

	info(String result, int num) {
		this.result = result;
		this.num = num;
	}

	public int compareTo(info o) {
		return result.length() - o.result.length();
	}
}
