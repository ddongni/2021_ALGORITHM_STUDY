package BJ11055_가장큰증가부분수열;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			dp[i] = arr[i];
		}
		int ans = Integer.MIN_VALUE;
		PriorityQueue<int[]> pq = new PriorityQueue<>((int[] a, int[] b) -> b[1] - a[1]);
		for (int i = 0; i < n; i++) {
			Queue<int[]> save = new LinkedList<>();
			while (!pq.isEmpty()) {
				int[] k = pq.poll();
				save.add(new int[] { k[0], k[1] });
				if (k[1] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[k[0]] + arr[i]);
				}
			}
			pq.add(new int[] { i, arr[i] });
			while (!save.isEmpty()) {
				int[] k = save.poll();
				pq.add(new int[] { k[0], k[1] });
			}
			ans = Math.max(ans, dp[i]);
		}
		System.out.println(ans);
	}
}
/*
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int i, j, n=sc.nextInt(), max = 0, a[] = new int[n+1], d[] = new int[n+1];
		
		for(i=1;i<=n;i++) a[i] = sc.nextInt();
		
		for(i=1;i<=n;i++){
			d[i] = a[i];
			for(j=1;j<i;j++)
				if(a[j]<a[i] && d[i] < d[j]+a[i]) d[i] = d[j] + a[i];
			if(max < d[i]) max = d[i];
		}
		System.out.println(max);
		sc.close();
	}
}
 */
