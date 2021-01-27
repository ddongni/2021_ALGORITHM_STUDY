package N05_돌그룹_12886;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/**
 * 문제를 잘 읽어보면 a + b + c 는 항상 일정, check[a][b]로 방문 여부 판단 할 수 있음
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { a, b, c });
		int answer = 0;
		boolean[][] check = new boolean[1501][1501];
		while (!q.isEmpty()) {
			int[] k = q.poll();
			Arrays.sort(k);
			if (check[k[0]][k[1]])
				continue;
			check[k[0]][k[1]] = true;
			if (k[0] == k[1] && k[1] == k[2]) {
				answer = 1;
				break;
			}
			if (k[0] != k[1]) {
				q.add(new int[] { k[0] * 2, k[1] - k[0], k[2] });
			}
			if (k[1] != k[2]) {
				q.add(new int[] { k[1] * 2, k[2] - k[1], k[0] });
			}
			if (k[0] != k[2]) {
				q.add(new int[] { k[0] * 2, k[2] - k[0], k[1] });
			}
		}
		System.out.println(answer);
	}
}
