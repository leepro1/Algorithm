/*
 * https://www.acmicpc.net/problem/11050
 * 이항 계수 1
 * dp를 이용하여 점화식으로 풀자
 * x개 중 y개를 뽑는 경우의 수 = x-1개 중 y-1개 뽑는 경우 + x-1개 중 y개 뽑는 경우
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11050 {
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
			}
		}

		System.out.println(dp[n][k]);
	}
}
