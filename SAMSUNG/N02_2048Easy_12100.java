package N02_2048Easy_12100;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *	걸린 시간 : 33분
 */
public class Main {
	static int[] r = { 0, 0 - 1, 1 }, c = { -1, 1, 0, 0 };
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[][] map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		change(0, map);
		System.out.println(answer);
	}

	static void change(int count, int[][] map) {
		if (count == 5)
			return;
		int[][] map_n1 = go_l(map);
		change(count + 1, map_n1);
		int[][] map_n2 = go_r(map);
		change(count + 1, map_n2);
		int[][] map_n3 = go_u(map);
		change(count + 1, map_n3);
		int[][] map_n4 = go_d(map);
		change(count + 1, map_n4);
	}

	static int[][] go_l(int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		int[][] change_map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0)
					continue;
				q.add(map[i][j]);
			}
			Queue<Integer> add = new LinkedList<>();
			int first = -1, count = 0;
			while (!q.isEmpty()) {
				int next = q.poll();
				if (first != next) {
					if (count == 1 && first!=-1)
						add.add(first);
					first = next;
					count = 1;
				}else if(first == next) {
					add.add(first * 2);
					first = -1;
				}
			}
			if (first != -1)
				add.add(first);
			for (int j = 0; j < n; j++) {
				if (!add.isEmpty()) {
					change_map[i][j] = add.poll();
					answer = Math.max(answer, change_map[i][j]);
				}
			}
		}
		return change_map;
	}

	static int[][] go_r(int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		int[][] change_map = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) {
				if (map[i][j] == 0)
					continue;
				q.add(map[i][j]);
			}
			Queue<Integer> add = new LinkedList<>();
			int first = -1, count = 0;
			while (!q.isEmpty()) {
				int next = q.poll();
				if (first != next) {
					if (count == 1 && first!=-1)
						add.add(first);
					first = next;
					count = 1;
				}else if(first == next) {
					add.add(first * 2);
					first = -1;
				}
			}
			if (first != -1)
				add.add(first);
			for (int j = n - 1; j >= 0; j--) {
				if (!add.isEmpty()) {
					change_map[i][j] = add.poll();
					answer = Math.max(answer, change_map[i][j]);
				}
			}
		}
		return change_map;
	}

	static int[][] go_u(int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		int[][] change_map = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int i = 0; i < n; i++) {
				if (map[i][j] == 0)
					continue;
				q.add(map[i][j]);
			}
			Queue<Integer> add = new LinkedList<>();
			int first = -1, count = 0;
			while (!q.isEmpty()) {
				int next = q.poll();
				if (first != next) {
					if (count == 1 && first!=-1)
						add.add(first);
					first = next;
					count = 1;
				}else if(first == next) {
					add.add(first * 2);
					first = -1;
				}
			}
			if (first != -1)
				add.add(first);
			for (int i = 0; i < n; i++) {
				if (!add.isEmpty()) {
					change_map[i][j] = add.poll();
					answer = Math.max(answer, change_map[i][j]);
				}
			}
		}
		return change_map;
	}

	static int[][] go_d(int[][] map) {
		Queue<Integer> q = new LinkedList<>();
		int[][] change_map = new int[n][n];
		for (int j = 0; j < n; j++) {
			for (int i = n - 1; i >= 0; i--) {
				if (map[i][j] == 0)
					continue;
				q.add(map[i][j]);
			}
			Queue<Integer> add = new LinkedList<>();
			int first = -1, count = 0;
			while (!q.isEmpty()) {
				int next = q.poll();
				if (first != next) {
					if (count == 1 && first!=-1)
						add.add(first);
					first = next;
					count = 1;
				}else if(first == next) {
					add.add(first * 2);
					first = -1;
				}
			}
			if (first != -1)
				add.add(first);
			for (int i = n - 1; i >= 0; i--) {
				if (!add.isEmpty()) {
					change_map[i][j] = add.poll();
					answer = Math.max(answer, change_map[i][j]);
				}
			}
		}
		return change_map;
	}

}
