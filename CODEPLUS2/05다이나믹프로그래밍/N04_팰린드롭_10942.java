package N04_팰린드롭_10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			int mid = (s + e) / 2;
			boolean check = true;
			while (s < e) {
				if (arr[s] != arr[e]) {
					check = false;
					break;
				}
				s++;
				e--;
			}
			if (!check) {
				sb.append(0+"\n");
			} else {
				sb.append(1+"\n");
			}
		}
		System.out.println(sb.toString());
	}
}
