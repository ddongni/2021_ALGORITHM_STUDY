package BJ9184_신나는함수실행;

import java.util.Scanner;

public class Main {
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		dp = new int[21][21][21];
		StringBuilder sb = new StringBuilder();
		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			if (x == -1 && y == -1 && z == -1)
				break;
			sb.append("w(" + x + ", " + y + ", " + z + ") = " + w(x, y, z) + "\n");
		}
		System.out.println(sb.toString());
	}

	static int w(int x, int y, int z) {
		if (x <= 0 || y <= 0 || z <= 0)
			return 1;

		if (x > 20 || y > 20 || z > 20)
			return dp[20][20][20] = w(20, 20, 20);

		if (dp[x][y][z] != 0)
			return dp[x][y][z];

		if (x < y && y < z) {
			return dp[x][y][z] = w(x, y, z - 1) + w(x, y - 1, z - 1) - w(x, y - 1, z);
		} else {
			return dp[x][y][z] = w(x - 1, y, z) + w(x - 1, y - 1, z) + w(x - 1, y, z - 1) - w(x - 1, y - 1, z - 1);
		}
	}
}
