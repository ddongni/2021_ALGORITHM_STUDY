package N01_문자열폭발_9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String c = br.readLine();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			st.push(s.charAt(i));
			if (st.size() >= c.length()) {
				boolean contain = true;
				for (int j = 0; j < c.length(); j++) {
					if (st.get(st.size() - c.length() + j) != c.charAt(j)) {
						contain = false;
						break;
					}
				}
				if (contain) {
					for (int j = 0; j < c.length(); j++) {
						st.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (char x : st) {
			sb.append(x);
		}
		System.out.println(sb.length() == 0 ? "FRULA" : sb.toString());
	}
}
