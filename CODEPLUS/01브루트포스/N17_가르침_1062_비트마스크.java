package N17_가르침_1062_비트마스크;

import java.util.Scanner;

public class Main {
	static int[] str;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		str = new int[n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			int S = 0;
			for (int j = 0; j < s.length(); j++) {
				S = S | (1 << (s.charAt(j) - 'a'));
			}
			str[i] = S;
		}
		int include = (1 << 0) | (1 << 2) | (1 << 8) | (1 << 13) | (1 << 19);
		int answer = 0;
		for (int i = k - 1; i < 1 << 26; i++) {
			if ((i | include) != i)
				continue;
			int count = 0;
			for (int j = 0; j < 26; j++) {
				if ((i & (1 << j)) != 0) {
					count++;
				}
			}
			if (count == k) {
				int num = 0;
				for (int l = 0; l < n; l++) {
					if ((i | str[l]) == i) {
						num++;
					}
				}
				answer = Math.max(answer, num);
			}
		}
		System.out.println(answer);
	}
}
