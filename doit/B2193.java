/*
 * https://www.acmicpc.net/problem/2193
 * 이친수
 * 패턴 dp 문제, long형으로 dp를 만들어야한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2193 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		long[][] dp = new long[n + 1][2]; // 0과 1의 패턴
		dp[1][0] = 0;
		dp[1][1] = 1;

		for (int i = 2; i <= n; i++) {
			dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
			dp[i][1] = dp[i - 1][0];
		}

		System.out.println(dp[n][0] + dp[n][1]);
	}
}
