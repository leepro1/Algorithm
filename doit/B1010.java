/*
 * https://www.acmicpc.net/problem/1010
 * 다리 놓기
 * 서쪽 N개에 동쪽 M개중 N개를 뽑아서 연결하는 문제다
 * 겹치면 안되므로 순서가 정해져 있다. 그냥 뽑으면 되니 조합문제이다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1010 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[][] dp = new int[31][31];

		for (int i = 0; i <= 30; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
			dp[i][1] = i;

			for (int j = 2; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		while (t-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			sb.append(dp[m][n] + "\n");
		}

		System.out.println(sb);
	}
}
