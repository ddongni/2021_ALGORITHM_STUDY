package N14_병든나이트_1783;

import java.util.Scanner;

/**
 * 1. 세로 1 일 경우 -> 1개 
 * 2. 세로 2 일 경우 -> 최대 4개 or (m-3)/2+2개 
 * 3. 세로 3 이상일 경우 
 * 	1) 가로가 7 이상일 경우 -> 가로 길이에서 7을 빼주고 시작, 5개 더하기 
 * 	2) 가로가 7 미만일 경우 -> 최대 4개 or 가로 길이 중에 작은 값
 */
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if (n == 1) {
			System.out.println(1);
		} else if (n == 2) {
			System.out.println(Math.min(4, (m+1)/2));
		} else if (n >= 3) {
			if (m < 7) {
				System.out.println(Math.min(4, m));
			} else if (m >= 7) {
				System.out.println(m - 7 + 5);
			}
		}
	}
}
