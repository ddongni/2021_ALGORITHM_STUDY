package BJ1010_다리놓기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-->0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int ans = 1;
			for(int i=1;i<=n;i++) {
				ans *= m--;
				ans /= i;
			}
			System.out.println(ans);
		}
	}
}
