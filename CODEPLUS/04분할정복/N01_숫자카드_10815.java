package N01_숫자카드_10815;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;
/**
 * 10,000,000을 더해서 푸는 방법도 있음
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
		int m = sc.nextInt();
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> a[0] - b[0]);
		int[] ans = new int[m];
		for (int i = 0; i < m; i++) {
			pq.add(new int[] { sc.nextInt(), i });
		}
		int idx = 0;
		for (int i = 0; i < m; i++) {
			while (idx < n) {
				if(pq.isEmpty())
					break;
				int[] k = pq.peek();
				if (arr[idx] > k[0]) {
					pq.poll();
					break;
				}else if (arr[idx] == k[0]) {
					ans[k[1]] = 1;
					pq.poll();
					break;
				}
				idx++;
			}
		}
		for(int i =0;i<m;i++) {
			System.out.print(ans[i]+" ");
		}
	}
}

class info {
	int idx, num;

	info(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
}
