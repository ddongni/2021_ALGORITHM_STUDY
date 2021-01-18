package N02_단어수학_1339;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 브루트포스 라기 보다는 간단한 수학 문제였음.
 */
public class Main {
	static String[] str;
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		int[] alpha = new int[26];
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String str = sc.next();
			int mul = 1;
			int str_length = str.length() - 1;
			while (str_length-- > 0) {
				mul *= 10;
			}
			for (int j = 0; j < str.length(); j++) {
				alpha[str.charAt(j) - 'A'] += mul;
				mul /= 10;
			}
		}
		PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < 26; i++) {
			if(alpha[i]==0)
				continue;	
			q.add(alpha[i]);
		}
		int num = 9;
		int answer = 0;
		while(!q.isEmpty()) {
			answer += q.poll()*num;
			num--;
		}
		System.out.println(answer);
	}
}
