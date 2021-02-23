package N02_배열합치기_11728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 하나의 배열에 넣어서 정렬해주기만 하면 되는 방법도 있음
 */
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] comp = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			comp[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		Arrays.sort(comp);
		int idx1 = 0;
		int idx2 = 0, idx3 = 0;
		StringBuilder sb = new StringBuilder();
		while (idx1 < n || idx2 < m ) {
			while (idx1 < n  && arr[idx1] < comp[idx2]) {
				sb.append(arr[idx1++]+" ");
			}
			if(idx1==n) {
				while(idx2<m) {
					sb.append(comp[idx2++]+" ");
				}
				break;
			}
			while (idx2 < m && arr[idx1] >= comp[idx2]) {
				sb.append(comp[idx2++]+" ");
			}
			if(idx2==m) {
				while(idx1<n) {
					sb.append(arr[idx1++]+" ");
				}
				break;
			}
		}
		System.out.println(sb.toString());
	}
}
