package N10_연산자_14888;

import java.util.Scanner;
/**
 * 걸린 시간 : 15분
 */
public class Main {
	static int total = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[n];
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		int[] cal = new int[4];
		for (int i = 0; i < 4; i++) {
			cal[i] = sc.nextInt();
			total += cal[i];
		}
		select(num,cal,0,num[0],1);
		System.out.println(max+"\n"+min);

	}

	static void select(int[] num, int[] cal, int count, int ans, int idx) {
		if (count == total) {
			max = Math.max(max, ans);
			min = Math.min(min, ans);
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (cal[i] == 0)
				continue;
			cal[i]--;
			int new_ans = ans;
			if (i == 0) {
				new_ans += num[idx];
			} else if (i == 1) {
				new_ans -= num[idx];
			} else if (i == 2) {
				new_ans *= num[idx];
			} else {
				new_ans /= num[idx];
			}
			select(num, cal, count + 1, new_ans, idx + 1);
			cal[i]++;
		}
	}
}
