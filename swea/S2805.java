package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2805 {
	static int n, sum;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= t; test_case++) {
			n = Integer.parseInt(br.readLine());

			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < n; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}

			sum = 0;
			sumCrops(n / 2, 0, n);

			sb.append("#" + test_case + " " + sum + "\n");
		}
		System.out.println(sb);
	}

	public static void sumCrops(int x, int y, int EndIndex) {
		if (x < 0 || x >= n)
			return;

		for (int i = y; i < EndIndex; i++) {
			sum += map[x][i];
		}

		if (x <= n / 2)
			sumCrops(x - 1, y + 1, EndIndex - 1);

		if (x >= n / 2)
			sumCrops(x + 1, y + 1, EndIndex - 1);

		return;
	}
}
