package N02_히스토그램에서가장큰직사각형_6549;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * 세그먼트 트리 풀이 방법도 있음
 * https://www.acmicpc.net/blog/view/12
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while (true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			if (x == 0)
				break;
			int[] num = new int[x];
			for (int i = 0; i < x; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			Stack<Integer> stack = new Stack<>();
			long answer = Long.MIN_VALUE;
			for (int i = 0; i < x; i++) {
				while (!stack.isEmpty() && num[stack.peek()] > num[i]) {
					int idx = stack.pop();
					int width = stack.isEmpty() ? i : i - stack.peek() - 1;
					answer = Math.max(answer, (long) width * num[idx]);
				}
				stack.push(i);
			}
			while (!stack.isEmpty()) {
				int idx = stack.pop();
				int width = stack.isEmpty() ? x : x - stack.peek() - 1;
				answer = Math.max(answer, (long) width * num[idx]);
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb.toString());
	}
}
