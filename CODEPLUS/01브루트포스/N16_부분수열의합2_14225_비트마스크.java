package N16_부분수열의합2_14225_비트마스크;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/**
 * HashSet 정렬 안됨
 */
public class Main {
	static int[] arr;
	static int n;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		List<Integer> li = new LinkedList<>();
		for (int i = 1; i < (1 << n); i++) {
			int sum = 0;
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) != 0) {
					sum += arr[j];
				}
			}
			li.add(sum);
		}
		Collections.sort(li);
		int idx = 1;
		for (int x : li) {
			if (x == idx) {
				idx++;
			} else if (x > idx) {
				System.out.println(idx);
				return;
			}
		}
		System.out.println(idx);
	}
}
