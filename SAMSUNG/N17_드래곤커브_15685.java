package N17_드래곤커브_15685;

import java.util.Scanner;
import java.util.Stack;

/**
 *  걸린 시간 : 53분
 */
public class Main {
	static int[] r = { 0, -1, 0, 1 }, c = { 1, 0, -1, 0 }, change = { 1, 2, 3, 0 };
	static int[][] map = new int[201][201];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			int y = sc.nextInt();
			int x = sc.nextInt();
			int d = sc.nextInt();
			int g = sc.nextInt();
			Stack<int[]> s = new Stack<>();
			map[x][y] = 1;
			s.push(new int[] { x + r[d], y + c[d], d });
			gen(g, s);
		}
		int ans = 0;
		for (int i = 0; i < 201; i++) {
			for (int j = 0; j < 201; j++) {
				if (map[i][j] == 1) {
					boolean check = true;
					if (map[i][j + 1] != 1 || map[i + 1][j] != 1 || map[i + 1][j + 1] != 1)
						check = false;
					if (check)
						ans++;
				}
			}
		}
		System.out.println(ans);
	}

	static void gen(int g, Stack<int[]> s) {
		if (g == 0) {
			while (!s.isEmpty()) {
				int[] k = s.pop();
				map[k[0]][k[1]] = 1;
			}
			return;
		}
		Stack<int[]> ns = new Stack<>();
		for (int[] k : s) {
			ns.push(k);
		}
		int x = ns.peek()[0], y = ns.peek()[1];
		while (!ns.isEmpty()) {
			int[] k = ns.pop();
			x += r[change[k[2]]];
			y += c[change[k[2]]];
			s.push(new int[] { x, y, change[k[2]] });
		}
		gen(g - 1, s);
	}
}
