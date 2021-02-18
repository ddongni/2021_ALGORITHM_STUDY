package N13_30_10610;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String n = sc.next();
		int sum = 0;
		boolean iszero = false;
		int[] arr = new int[n.length()];
		for (int i = 0; i < n.length(); i++) {
			int num = n.charAt(i) - '0';
			if (num == 0) {
				iszero = true;
			}
			sum += num;
			arr[i] = num;
		}
		Arrays.sort(arr);
		if (sum % 3 == 0 && iszero) {
			for (int i = arr.length - 1; i >= 0; i--) {
				System.out.print(arr[i]);
			}
		} else {
			System.out.println(-1);
		}
	}
}
