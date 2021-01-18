package N03_연산자끼워넣기_14888;

import java.util.Scanner;
/**
 * 변수 설정 잘하기. ex) N or n
 */
public class Main {
	static int[] num, cal;
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		num = new int[N];
		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		cal = new int[N - 1];
		int index = 0;
		for (int i = 0; i < 4; i++) {
			int count = sc.nextInt();
			while (count-- > 0) {
				// 부호의 갯수만큼 cal 배열에 부호(i로 대체) 넣어주기
				cal[index] = i;
				index++;
			}
		}
		p(1, num[0], 0);
		System.out.println(max);
		System.out.println(min);
	}

	static void p(int idx, int n, int s) {
		if (s==((1<<(N-1))-1)) {
			max = Math.max(max, n);
			min = Math.min(min, n);
			return;
		}
		for (int i = 0; i < N - 1; i++) {
			if ((s & (1 << i)) == 0) {
				int new_n = n;
				if (cal[i] == 0) {
					new_n +=num[idx];
				} else if (cal[i] == 1) {
					new_n -=num[idx];
				} else if (cal[i] == 2) {
					new_n *=num[idx];
				} else if (cal[i] == 3) {
					new_n /=num[idx];
				}
				p(idx + 1, new_n, s | (1 << i));
			}
		}
	}
}
