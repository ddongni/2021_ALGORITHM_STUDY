package N11_수묶기_1744;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 1. 0을 포함한 음수는 작은 수 부터 묶는다.
 * 2. 1보다 큰 수는 큰 수부터 묶는다.
 * 3. 숫자가 1인 경우에는 묶지 않는다.
 * https://m.blog.naver.com/PostView.nhn?blogId=pjok1122&logNo=221652191176&proxyReferer=https:%2F%2Fwww.google.com%2F
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = 0, mul = 1, count = 0;
		int save_index = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			int num = arr[i];
			if (num > 0) {
				save_index = i;
				break;
			}
			mul *= num;
			count++;
			if (count == 2) {
				ans += mul;
				count = 0;
				mul = 1;
			}
		}
		if (count == 1) {
			ans += mul;
		}
		mul = 1;
		int last_count = 0;
		for (int i = n - 1; i >= save_index; i--) {
			int num = arr[i];
			if (num == 1) {
				ans++;
				continue;
			}
			mul *= num;
			last_count++;
			if (last_count == 2) {
				ans += mul;
				last_count = 0;
				mul = 1;
			}
		}
		if (last_count == 1) {
			ans += mul;
		}
		System.out.println(ans);
	}
}
