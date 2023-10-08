/*
 * https://www.acmicpc.net/problem/11051
 * 이항 계수 2
 * 이항 계수 1 문제와 같음
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11051 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[][] dp = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
			dp[i][1] = i;

			for (int j = 2; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				dp[i][j] %= 10007;
			}
		}

		System.out.println(dp[n][k]);
	}
}
