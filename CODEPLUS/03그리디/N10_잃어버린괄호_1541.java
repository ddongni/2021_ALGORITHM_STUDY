package N10_잃어버린괄호_1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * split("\\+") 
 */
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), "-");
		Queue<Integer> q = new LinkedList<>();
		while (st.hasMoreTokens()) {
			String s = st.nextToken();
			if (s.length() <= 1) {
				q.add(Integer.parseInt(s));
			} else {
				StringTokenizer st2 = new StringTokenizer(s, "+");
				int sum =0;
				while (st2.hasMoreTokens()) {
					sum += Integer.parseInt(st2.nextToken());
				}
				q.add(sum);
			}
		}
		int answer = q.poll();
		while(!q.isEmpty()) {
			answer -= q.poll();
		}
		System.out.println(answer);
	}
}
