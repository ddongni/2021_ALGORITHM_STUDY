package BJ11660_구간합구하기5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] array = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += array[i][j];
				dp[i][j] = sum;
			}
		}
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] += dp[i - 1][j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());

			sb.append((dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1]) + "\n");
		}
		System.out.println(sb.toString());
	}
}
/*
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n;j++) {
				map[i][j] = sc.nextInt();
				dp[i][j] = dp[i-1][j]+dp[i][j-1]-dp[i-1][j-1]+map[i][j]; 
			}
		}
		for(int i=0;i<m;i++) {
			int x1 = sc.nextInt();
			int y1  =sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			System.out.println(dp[x2][y2]-dp[x2][y1-1]-dp[x1-1][y2]+dp[x1-1][y1-1]);
		}
	}
}
*/
