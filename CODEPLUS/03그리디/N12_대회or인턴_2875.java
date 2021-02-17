package N12_대회or인턴_2875;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int idx = n / 2;
		for (int i = idx; i >= 0; i--) {
			int a = n - i * 2;
			int b = m - i * 1;
			if (a < 0 || b < 0)
				continue;
			if (a + b >= k) {
				System.out.println(i);
				break;
			}
		}
	}
}
