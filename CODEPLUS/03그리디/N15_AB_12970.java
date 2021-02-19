package N15_AB_12970;

import java.util.Scanner;
/**
 *	https://blog.naver.com/gustn3964/222235197255 
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String ans = "";
		int idx = 0;
		int count = 0;
		int sum = 0;
		while (idx < n && ans.length() != n) {
			System.out.println(idx);
			for (int i = idx; i < n; i++) {
				if (sum - count + (n - (i + 1)) <= k) {
					sum = sum - count + (n - (i + 1));
					ans += "A";
					idx = i + 1;
					count++;
					if (sum == k) {
						for (int j = i + 1; j < n; j++) {
							ans += "B";
						}
					}
					break;
				} else {
					ans += "B";
				}
			}
		}
		System.out.println(ans.contains("B") ? ans : -1);
	}
}
