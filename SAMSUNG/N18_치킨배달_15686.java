package N18_치킨배달_15686;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * 걸린 시간 : 17분 
 */
public class Main {
	static int answer = Integer.MAX_VALUE;
	static List<int[]> chicken, house;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		chicken = new LinkedList<>();
		house = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int num = sc.nextInt();
				if (num == 1) {
					house.add(new int[] { i, j });
				} else if (num == 2) {
					chicken.add(new int[] { i, j });
				}
			}
		}
		for (int i = 1; i <= m; i++) {
			int[] arr = new int[i];
			combi(arr, chicken.size(), i, 0, 0);
		}
		System.out.println(answer);
	}

	static void combi(int[] arr, int n, int r, int index, int target) {
		if (r == 0) {
			int sum = 0;
			for (int i = 0; i < house.size(); i++) {
				int min = Integer.MAX_VALUE;
				for (int j = 0; j < arr.length; j++) {
					int[] k = chicken.get(arr[j]);
					min = Math.min(min, Math.abs(k[0] - house.get(i)[0]) + Math.abs(k[1] - house.get(i)[1]));
				}
				sum += min;
			}
			answer = Math.min(answer, sum);
			return;
		}
		if (target == n)
			return;
		arr[index] = target;
		combi(arr, n, r - 1, index + 1, target + 1);
		combi(arr, n, r, index, target + 1);

	}
}
