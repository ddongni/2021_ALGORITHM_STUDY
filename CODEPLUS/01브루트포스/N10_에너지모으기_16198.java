package N10_에너지모으기_16198;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n, answer = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		List<Integer> num = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			num.add(sc.nextInt());
		}
		select(num, 0);
		System.out.println(answer);
	}

	static void select(List<Integer> num, int sum) {
		if (num.size() == 2) {
			answer = Math.max(answer, sum);
			return;
		}
		for (int i = 1; i < num.size() - 1; i++) {
			int left = num.get(i - 1);
			int right = num.get(i + 1);
			int x = num.remove(i);
			select(num, sum + left * right);
			num.add(i, x);
		}
	}
}
