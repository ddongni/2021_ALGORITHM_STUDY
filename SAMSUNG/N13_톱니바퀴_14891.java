package N13_톱니바퀴_14891;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 걸린 시간 : 30분
 */
public class Main {
	static LinkedList<Integer>[] dq = new LinkedList[4];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			String st = sc.nextLine();
			dq[i] = new LinkedList<>();
			for (int j = 0; j < 8; j++) {
				dq[i].add(st.charAt(j) - '0');
			}
		}
		int k = sc.nextInt();
		for (int i = 0; i < k; i++) {
			int num = sc.nextInt() - 1;
			int dir = sc.nextInt();
			check_left(num, dir);
			check_right(num, dir);
			turn(num, dir);
		}
		int answer = 0;
		if (dq[0].get(0) == 1)
			answer += 1;
		if (dq[1].get(0) == 1)
			answer += 2;
		if (dq[2].get(0) == 1)
			answer += 4;
		if (dq[3].get(0) == 1)
			answer += 8;
		System.out.println(answer);
	}

	static void check_left(int num, int dir) {
		if (num - 1 >= 0) {
			if (dq[num - 1].get(2) != dq[num].get(6)) {
				check_left(num - 1, dir * (-1));
				turn(num - 1, dir * (-1));
			}
		}
	}

	static void check_right(int num, int dir) {
		if (num + 1 <= 3) {
			if (dq[num + 1].get(6) != dq[num].get(2)) {
				check_right(num + 1, dir * (-1));
				turn(num + 1, dir * (-1));
			}
		}
	}

	static void turn(int num, int dir) {
		if (dir == 1) { // 시계방향
			dq[num].addFirst(dq[num].pollLast());
		} else { // 반시계방향
			dq[num].addLast(dq[num].pollFirst());
		}
	}
}
