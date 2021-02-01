package N03_ATM_11399;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum =0, answer = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			answer += sum;
		}
		System.out.println(answer);
	}
}
