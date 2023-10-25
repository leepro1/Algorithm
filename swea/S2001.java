package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2001 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, m, max;
		int[][] arr, sum;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			arr = new int[n + 1][n + 1];
			sum = new int[n + 1][n + 1];

			max = 0;
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + arr[i][j];

					if (i >= m && j >= m) {
						int temp = sum[i][j] - sum[i - m][j] - sum[i][j - m] + sum[i - m][j - m];
						max = Math.max(max, temp);
					}
				}
			}

			sb.append("#" + test_case + " " + max + "\n");
		}

		System.out.println(sb);
	}
}