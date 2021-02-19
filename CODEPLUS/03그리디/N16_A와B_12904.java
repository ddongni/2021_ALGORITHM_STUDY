package N16_A와B_12904;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
/**
 * 	StringBuilder 사용
 * 
  		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String S = bf.readLine();
		
		StringBuilder T = new StringBuilder(bf.readLine());
		
		while(T.length()>S.length()) {
			
			if(T.charAt(T.length()-1)=='A') {
				T.deleteCharAt(T.length()-1);
			}else {
				T.deleteCharAt(T.length()-1);
				T.reverse();
			}
		}
		
		if(S.equals(T.toString())) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t = sc.next();
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < t.length(); i++) {
			st.push(t.charAt(i));
		}
		while (!st.isEmpty()) {
			char top = st.pop();
			if (top == 'B') {
				Queue<Character> new_st = new LinkedList<>();
				while (!st.isEmpty()) {
					new_st.add(st.pop());
				}
				while (!new_st.isEmpty()) {
					st.add(new_st.poll());
				}
			}
			String str = "";
			for (char c : st) {
				str += c;
			}
			if (str.length() == s.length()) {
				System.out.println(str.equals(s)?1:0);
				return;
			}
		}
	}
}
