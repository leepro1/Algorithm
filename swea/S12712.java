package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12712 {
	static int n, m, max;
	static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			arr = new int[n][n];
			// 배열 입력부
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					checkPlus(i, j);
					checkX(i, j);
				}
			}
			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

	static void checkPlus(int x, int y) {
		int sum = 0;

		// 가로방향
		for (int i = y - (m - 1); i <= y + (m - 1); i++) {
			if (i >= n) {
				break;
			}
			if (i < 0) {
				continue;
			}
			sum += arr[x][i];
		}
		// 세로방향
		for (int i = x - (m - 1); i <= x + (m - 1); i++) {
			if (i >= n) {
				break;
			}
			if (i < 0) {
				continue;
			}
			sum += arr[i][y];
		}

		sum -= arr[x][y];

		max = Math.max(max, sum);
	}

	static void checkX(int x, int y) {
		int sum = 0;
		int i = x - m;
		int j = y - m;

		// 우하향
		while (i < x + m - 1 && j < y + m - 1) {
			i++;
			j++;

			if (i >= n || j >= n) {
				break;
			}
			if (i < 0 || j < 0) {
				continue;
			}
			sum += arr[i][j];
		}

		i = x + m;
		j = y - m;

		// 우상향
		while (i >= x - m + 1 && j < y + m - 1) {
			i--;
			j++;

			if (i < 0 || j >= n) {
				break;
			}
			if (i >= n || j < 0) {
				continue;
			}
			sum += arr[i][j];
		}
		sum -= arr[x][y];

		max = Math.max(max, sum);
	}
}
