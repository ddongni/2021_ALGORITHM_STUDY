package N09_뮤탈리스크_12869;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] f = { { 9, 3, 1 }, { 9, 1, 3 }, { 3, 9, 1 }, { 3, 1, 9 }, { 1, 3, 9 }, { 1, 9, 3 } };
	static int answer = Integer.MAX_VALUE;
	static boolean[][][] check;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		check = new boolean[61][61][61];
		int[] num = new int[3];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		go(num[0], num[1], num[2], 0);
		System.out.println(answer);
	}

	static void go(int x, int y, int z, int count) {
		//내림차순으로 정렬
		int[] num = new int[3];
		num[0] = x;
		num[1] = y;
		num[2] = z;
		Arrays.sort(num);
		x = num[2];
		y = num[1];
		z = num[0];
		
		if (x <= 0 && y <= 0 && z <= 0) {
			answer = Math.min(answer, count);
			return;
		}
		if (check[x][y][z])
			return;
		check[x][y][z] = true;
		if (answer < count)
			return;
		for (int i = 0; i < 6; i++) {
			int nx = 0, ny = 0, nz = 0;
			if (x - f[i][0] > 0)
				nx = x - f[i][0];
			if (y - f[i][1] > 0)
				ny = y - f[i][1];
			if (z - f[i][2] > 0)
				nz = z - f[i][2];
			go(nx, ny, nz, count + 1);
		}
	}
}
