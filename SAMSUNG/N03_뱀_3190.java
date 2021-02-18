package N03_뱀_3190;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 걸린 시간 : 25분
 */
public class Main {
	public static void main(String[] args) {
		int[] r = { 0, 0, -1, 1 }, c = { 1, -1, 0, 0 };
		int[][] change_d = { { 2, 3, 1, 0 }, { 3, 2, 0, 1 } };
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int K = sc.nextInt();
		for (int i = 0; i < K; i++) {
			map[sc.nextInt() - 1][sc.nextInt() - 1] = 1;
		}
		int L = sc.nextInt();
		Queue<int[]> move = new LinkedList<>();
		for (int i = 0; i < L; i++) {
			int t = sc.nextInt();
			String d = sc.next();
			if (d.equals("L"))
				move.add(new int[] { t, 0 });
			else
				move.add(new int[] { t, 1 });
		}
		int dir = 0;
		Deque<int[]> snake = new LinkedList<>();
		map[0][0] = 9;
		snake.add(new int[] { 0, 0 });
		int time = 0;
		while (true) {
			if (!move.isEmpty()) {
				int[] k = move.peek();
				if (k[0] == time) {
					dir = change_d[k[1]][dir];
					move.poll();
				}
			}
			int[] s = snake.peekFirst();
			int nx = s[0] + r[dir];
			int ny = s[1] + c[dir];
			if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 9) // 게임 끝
				break;
			if (map[nx][ny] != 1) { // 사과가 아닐 때
				int[] k = snake.pollLast();
				map[k[0]][k[1]] = 0;
			}
			snake.addFirst(new int[] { nx, ny });
			map[nx][ny] = 9;
			time++;
		}
		System.out.println(time + 1);
	}
}
