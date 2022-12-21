//https://www.acmicpc.net/problem/9465
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9465 {
	private static int dp[][];
	private static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());
			arr = new int[2][n + 1];
			dp = new int[2][n + 1];

			for (int i = 0; i < 2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 1; j < n + 1; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];

			for (int i = 2; i < n + 1; i++) {
				dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + arr[1][i];
			}

			sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");

		}
		System.out.println(sb);
	}
}
