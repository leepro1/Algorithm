/*
 * https://www.acmicpc.net/problem/2775
 * 부녀회장이 될테야
 * 
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2775 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[][] dp = new int[15][15]; // 첫 원소는 호수, 두번째 원소는 층수이다.

		for (int i = 1; i <= 14; i++) {
			for (int j = 0; j <= 14; j++) {
				if (j == 0)
					dp[i][j] = dp[i - 1][j] + i;
				else
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}

		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine()); // 0층부터 시작
			int n = Integer.parseInt(br.readLine()); // 1호부터 시작

			sb.append(dp[n][k] - dp[n - 1][k] + "\n");
		}
		System.out.println(sb);
	}
}
