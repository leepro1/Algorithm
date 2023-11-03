package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1216 {
	static char[][] board;
	static int max;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int n = Integer.parseInt(br.readLine());
			
			board = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String str = br.readLine();
				for (int j = 0; j < 100; j++) {
					board[i][j] = str.charAt(j);
				}
			}

			max = 0;

			// 열 검사 -> flag == 0
			for (int k = 0; k < 100; k++) {
				for (int i = 0; i < 100; i++) {
					for (int j = i + 1; j < 100; j++) {
						// board[k][i] ~ board[k][j]
						if (j - i + 1 > max)
							checkPalindrome(0, k, i, j);
					}
				}
			}

			// 행 검사 -> flag == 0
			for (int k = 0; k < 100; k++) {
				for (int i = 0; i < 100; i++) {
					for (int j = i + 1; j < 100; j++) {
						// board[k][i] ~ board[k][j]
						if (j - i + 1 > max)
							checkPalindrome(1, k, i, j);
					}
				}
			}
			sb.append("#" + n + " " + max + "\n");
		}
		System.out.println(sb);
	}

	static void checkPalindrome(int flag, int index, int start, int end) {
		// 열 검사
		if (flag == 0) {
			int temp = end - start + 1;

			while (start < end) {
				if (board[index][start] == board[index][end]) {
					start++;
					end--;
				} else {
					return;
				}
			}
			max = Math.max(max, temp);
		}

		// 행 검사
		if (flag == 1) {
			int temp = end - start + 1;

			while (start < end) {
				if (board[start][index] == board[end][index]) {
					start++;
					end--;
				} else {
					return;
				}
			}
			max = Math.max(max, temp);
		}
	}
}
