package N19_큐빙_5373;

import java.util.Scanner;
/**
 * 걸린 시간 : 2시간 
 */
public class Main {
	static char[][] map;
	static int[][][] T = {
			{ { 0, 3 }, { 1, 3 }, { 2, 3 }, { 3, 3 }, { 4, 3 }, { 5, 3 }, { 6, 3 }, { 7, 3 }, { 8, 3 }, { 9, 3 },
					{ 10, 3 }, { 11, 3 } },
			{ { 11, 5 }, { 10, 5 }, { 9, 5 }, { 8, 5 }, { 7, 5 }, { 6, 5 }, { 5, 5 }, { 4, 5 }, { 3, 5 }, { 2, 5 },
					{ 1, 5 }, { 0, 5 } },
			{ { 5, 0 }, { 5, 1 }, { 5, 2 }, { 5, 3 }, { 5, 4 }, { 5, 5 }, { 5, 6 }, { 5, 7 }, { 5, 8 }, { 9, 5 },
					{ 9, 4 }, { 9, 3 } },
			{ { 3, 8 }, { 3, 7 }, { 3, 6 }, { 3, 5 }, { 3, 4 }, { 3, 3 }, { 3, 2 }, { 3, 1 }, { 3, 0 }, { 11, 3 },
					{ 11, 4 }, { 11, 5 } },
			{ { 2, 3 }, { 2, 4 }, { 2, 5 }, { 3, 6 }, { 4, 6 }, { 5, 6 }, { 6, 5 }, { 6, 4 }, { 6, 3 }, { 5, 2 },
					{ 4, 2 }, { 3, 2 } },
			{ { 8, 3 }, { 8, 4 }, { 8, 5 }, { 5, 8 }, { 4, 8 }, { 3, 8 }, { 0, 5 }, { 0, 4 }, { 0, 3 }, { 3, 0 },
					{ 4, 0 }, { 5, 0 } } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			map = new char[12][9];
			for (int i = 0; i < 3; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = 'o';
				}
			}
			for (int i = 3; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					map[i][j] = 'g';
				}
			}
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = 'w';
				}
			}
			for (int i = 3; i < 6; i++) {
				for (int j = 6; j < 9; j++) {
					map[i][j] = 'b';
				}
			}
			for (int i = 6; i < 9; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = 'r';
				}
			}
			for (int i = 9; i < 12; i++) {
				for (int j = 3; j < 6; j++) {
					map[i][j] = 'y';
				}
			}
			int n = sc.nextInt();
			while (n-- > 0) {
				String st = sc.next();
				char dir = st.charAt(1);
				switch (st.charAt(0)) {
				case 'L':
					turn(3, 0, 0, dir);
					break;
				case 'U':
					turn(3, 3, 4, dir);
					break;
				case 'B':
					turn(0, 3, 3, dir);
					break;
				case 'R':
					turn(3, 6, 1, dir);
					break;
				case 'F':
					turn(6, 3, 2, dir);
					break;
				case 'D':
					turn(9, 3, 5, dir);
					break;
				default:
					break;
				}
			}
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	static void turn(int x, int y, int sel, char dir) {
		if (dir == '+') {
			char[][] copy = new char[12][9];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					copy[x + i][y + j] = map[x + i][y + j];
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[x + j][y + 2 - i] = copy[x + i][y + j];
				}
			}
			for (int i = 11; i >= 3; i -= 3) {
				char[] temp = new char[3];
				temp[0] = map[T[sel][i - 2 - 3][0]][T[sel][i - 2 - 3][1]];
				temp[1] = map[T[sel][i - 1 - 3][0]][T[sel][i - 1 - 3][1]];
				temp[2] = map[T[sel][i - 3][0]][T[sel][i - 3][1]];
				map[T[sel][i - 2 - 3][0]][T[sel][i - 2 - 3][1]] = map[T[sel][i - 2][0]][T[sel][i - 2][1]];
				map[T[sel][i - 1 - 3][0]][T[sel][i - 1 - 3][1]] = map[T[sel][i - 1][0]][T[sel][i - 1][1]];
				map[T[sel][i - 3][0]][T[sel][i - 3][1]] = map[T[sel][i][0]][T[sel][i][1]];
				map[T[sel][i - 2][0]][T[sel][i - 2][1]] = temp[0];
				map[T[sel][i - 1][0]][T[sel][i - 1][1]] = temp[1];
				map[T[sel][i][0]][T[sel][i][1]] = temp[2];
			}
		} else {
			char[][] copy = new char[12][9];
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					copy[x + i][y + j] = map[x + i][y + j];
				}
			}
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					map[x + 2 - j][y + i] = copy[x + i][y + j];
				}
			}
			for (int i = 0; i < 9; i += 3) {
				char[] temp = new char[3];
				temp[0] = map[T[sel][i + 3][0]][T[sel][i + 3][1]];
				temp[1] = map[T[sel][i + 1 + 3][0]][T[sel][i + 1 + 3][1]];
				temp[2] = map[T[sel][i + 2 + 3][0]][T[sel][i + 2 + 3][1]];
				map[T[sel][i + 3][0]][T[sel][i + 3][1]] = map[T[sel][i][0]][T[sel][i][1]];
				map[T[sel][i + 1 + 3][0]][T[sel][i + 1 + 3][1]] = map[T[sel][i + 1][0]][T[sel][i + 1][1]];
				map[T[sel][i + 2 + 3][0]][T[sel][i + 2 + 3][1]] = map[T[sel][i + 2][0]][T[sel][i + 2][1]];
				map[T[sel][i][0]][T[sel][i][1]] = temp[0];
				map[T[sel][i + 1][0]][T[sel][i + 1][1]] = temp[1];
				map[T[sel][i + 2][0]][T[sel][i + 2][1]] = temp[2];
			}

		}
	}
}
