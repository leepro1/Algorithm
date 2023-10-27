package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1215 {
	static char[][] charMatrix;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int cnt;
		String str;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			charMatrix = new char[8][8];

			for (int i = 0; i < 8; i++) {
				str = br.readLine();
				for (int j = 0; j < 8; j++) {
					charMatrix[i][j] = str.charAt(j);
				}
			}

			cnt = 0;

			for (int i = 0; i <= 8 - n; i++) {
				cnt += checkPalindromeRow(i, i + n - 1);
				cnt += checkPalindromeCol(i, i + n - 1);
			}

			sb.append("#" + t + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	public static int checkPalindromeRow(int startOrigin, int endOrigin) {
		int tempCnt = 0;
		int start = startOrigin;
		int end = endOrigin;

		for (int i = 0; i < 8; i++) {
			while (start < end) {
				if (charMatrix[i][start] == charMatrix[i][end]) {
					start++;
					end--;
				} else {
					tempCnt--;
					break;
				}
			}
			tempCnt++;
			start = startOrigin;
			end = endOrigin;
		}
		return tempCnt;
	}

	public static int checkPalindromeCol(int startOrigin, int endOrigin) {
		int tempCnt = 0;
		int start = startOrigin;
		int end = endOrigin;

		for (int i = 0; i < 8; i++) {
			while (start < end) {
				if (charMatrix[start][i] == charMatrix[end][i]) {
					start++;
					end--;
				} else {
					tempCnt--;
					break;
				}
			}
			tempCnt++;
			start = startOrigin;
			end = endOrigin;
		}
		return tempCnt;
	}
}
