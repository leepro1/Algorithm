//https://www.acmicpc.net/problem/12865
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12865 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[n + 1][2];
		int[][] dp = new int[n + 1][k + 1];

		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 1; j <= n; j++) {
				dp[j][i] = dp[j - 1][i];
				if (i - arr[j][0] >= 0) {
					dp[j][i] = Math.max(dp[j - 1][i], arr[j][1] + dp[j - 1][i - arr[j][0]]);
				}
			}
		}

		System.out.println(dp[n][k]);
	}
}
