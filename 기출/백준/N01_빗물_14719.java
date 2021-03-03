package N01_빗물_14719;

import java.util.Scanner;

/**
 * https://machine-geon.tistory.com/140
 * 
 * public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		map = new int[W];
		ret = left = right = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < W; i++) {
			int N = Integer.parseInt(st.nextToken());
			map[i] = N;
		}

		// 인덱스마다 모이는 빗물 계산 ( 1번째 기둥과 마지막 기둥의 위치는 제외 )
		for (int i = 1; i < W - 1; i++) {
			left = right = 0;
			// 왼쪽에서 가장 높은 건물의 높이
			for (int j = 0; j < i; j++) {
				left = Math.max(map[j], left);
			}
			// 오른쪽에서 가장 높은 건물의 높이
			for (int j = i + 1; j < W; j++) {
				right = Math.max(map[j], right);
			}
            // 더 낮은 건물을 기준으로 현재 인덱스에 모이는 빗물
			if (map[i] < left && map[i] < right) {
				ret += Math.min(left, right) - map[i];
			}
		}
		System.out.println(ret);
	}
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int h = sc.nextInt();
		int w = sc.nextInt();
		int[][] map = new int[h][w];
		for (int i = 0; i < w; i++) {
			int x = sc.nextInt();
			for (int j = 1; j <= x; j++) {
				map[h - j][i] = 1;
			}
		}
		int ans = 0;
		for (int i = 0; i < h; i++) {
			int count = 0, add = 0;
			for (int j = 0; j < w; j++) {
				if (map[i][j] == 0) {
					add++;
				} else {
					count++;
					if (count == 2) {
						ans += add;
						count = 1;
					}
					add = 0;
				}
			}
		}
		System.out.println(ans);
	}
}
