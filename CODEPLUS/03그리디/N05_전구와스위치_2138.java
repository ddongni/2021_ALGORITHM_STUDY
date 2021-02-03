package N05_전구와스위치_2138;

import java.util.Scanner;

public class Main {
	static int n, ans = 0, answer = Integer.MAX_VALUE;
	static int[] b;
	static String str_b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int[] a = new int[n];
		int[] a2 = new int[n];
		b = new int[n];
		String str_a = sc.next();
		for (int i = 0; i < n; i++) {
			a[i] = str_a.charAt(i) - '0';
			a2[i] = str_a.charAt(i) - '0';
		}
		str_b = sc.next();
		for (int i = 0; i < n; i++) {
			b[i] = str_b.charAt(i) - '0';
		}
		// 안누를 때
		if (change(a)) {
			answer = Math.min(answer, ans);
		}
		// 누를 때
		a2[0] = 1 - a2[0];
		a2[1] = 1 - a2[1];
		if (change(a2)) {
			answer = Math.min(answer, ans + 1);
		}
		if (answer == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(answer);
		}

	}

	static boolean change(int[] a) {
		ans = 0;
		for (int i = 1; i < n; i++) {
			if (a[i - 1] != b[i - 1]) {
				int left = i - 1;
				int right = i + 1;
				if (left >= 0)
					a[left] = 1 - a[left];
				if (right < n)
					a[right] = 1 - a[right];
				a[i] = 1 - a[i];
				ans++;
			}
		}
		for (int j = 0; j < n; j++) {
			if (a[j] != b[j])
				return false;
		}
		return true;
	}
}
