package N03_오아시스재결합_3015;

import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Stack<long[]> st = new Stack<>();
		long ans = 0;
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			while (!st.isEmpty() && st.peek()[0] < num) {
				ans += st.pop()[1];
			}
			if (st.isEmpty()) {
				st.push(new long[] { num, 1 });
			} else {
				if (st.peek()[0] == num) {
					long[] k = st.pop();
					ans += k[1];
					if(!st.isEmpty()) {
						ans++; // num이 이전의 최대 값과 쌍을 이룸
					}
					st.push(new long[] { num, k[1] + 1 });

				} else { // num이 작을 경우, 이전의 최대 값과 쌍을 이룸
					st.push(new long[] { num, 1 });
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
