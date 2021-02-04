package N09_가장긴증가하는부분수열2_12015;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 이분탐색 이용, 시간 복잡도 nlogn
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> li = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int v = sc.nextInt();
			if (li.isEmpty() || v > li.get(li.size() - 1)) {
				li.add(v);
				continue;
			}
			int left = 0, right = li.size() - 1;
			while (left < right) {
				int mid = (left + right) / 2;
				if (li.get(mid) >= v) {
					right = mid;
				} else {
					left = mid + 1;
				}
			}
			li.set(right, v);
		}
		System.out.println(li.size());
	}
}
