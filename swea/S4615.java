package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S4615 {
	static int n;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int m, r, c;
		int cnt1, cnt2;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n + 1][n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				c = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());

				map[n / 2][n / 2] = map[n / 2 + 1][n / 2 + 1] = 2;
				map[n / 2][n / 2 + 1] = map[n / 2 + 1][n / 2] = 1;

				placeStone(r, c, Integer.parseInt(st.nextToken()));

				for (int k = 1; k <= n; k++) {
					for (int j = 1; j <= n; j++) {
						System.out.print(map[k][j] + " ");
					}
					System.out.println();
				}
				System.out.println("-------------");
			}

			cnt1 = 0;
			cnt2 = 0;

			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (map[i][j] == 1)
						cnt1++;
					else if (map[i][j] == 2)
						cnt2++;
				}
			}

			sb.append("#" + t + " " + cnt1 + " " + cnt2 + "\n");
		}
		System.out.println(sb);
	}

	public static void placeStone(int row, int col, int color) {
		map[row][col] = color;

		int start = 0;
		int end = 0;

		// 행 검사
		for (int i = 1; i < n; i++) {
			if (start == 0 && col - i >= 1 && map[row][col - i] == color) {
				start = col - i;
			}
			if (end == 0 && col + i <= n && map[row][col + i] == color) {
				end = col + i;
			}
		}
		if (start != 0 || end != 0) {
			if (start == 0)
				start = col;
			if (end == 0)
				end = col;

			for (int i = start; i <= end; i++) {
				map[row][i] = color;
			}
		}

		start = 0;
		end = 0;

		// 열 검사
		for (int i = 1; i < n; i++) {
			if (start == 0 && row - i >= 1 && map[row - i][col] == color) {
				start = row - i;
			}
			if (end == 0 && row + i <= n && map[row + i][col] == color) {
				end = row + i;
			}
		}

		if (start != 0 || end != 0) {
			if (start == 0)
				start = row;
			if (end == 0)
				end = row;

			for (int i = start; i <= end; i++) {
				map[i][col] = color;
			}
		}

		start = 0; // 여기서는 시작 헹
		int startCol = 0;
		end = 0; // 여기서는 끝 행

		// 우하향 검사
		for (int i = 1; i <= n; i++) {
			if (start == 0 && row - i >= 1 && col - i >= 1 && map[row - i][col - i] == color) {
				start = row - i;
				startCol = col - i;
			}
			if (end == 0 && row + i <= n && col + i <= n && map[row + 1][col + i] == color)
				end = row + i;

		}
		if (start != 0 || end != 0) {
			if (start == 0) {
				start = row;
				startCol = col;
			}
			if (end == 0)
				end = row;

			for (int i = start; i <= end; i++) {
				map[i][startCol++] = color;
			}
		}

		start = 0; // 여기서는 시작 헹
		startCol = 0;
		end = 0; // 여기서는 끝 행

		// 좌하향 검사
		for (int i = 1; i <= n; i++) {
			if (start == 0 && row - i >= 1 && col + i <= n && map[row - i][col + i] == color) {
				start = row - i;
				startCol = col + i;
			}
			if (end == 0 && row + i <= n && col - i >= 1 && map[row + 1][col - i] == color)
				end = row + i;

		}
		if (start != 0 || end != 0) {
			if (start == 0) {
				start = row;
				startCol = col;
			}
			if (end == 0)
				end = row;

			for (int i = start; i <= end; i++) {
				map[i][startCol--] = color;
			}
		}
	}
}
