//https://www.acmicpc.net/problem/1932
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1932 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j <= i; j++) {
				dp[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = n - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				dp[i - 1][j] += Math.max(dp[i][j], dp[i][j + 1]);
			}
		}
		System.out.println(dp[0][0]);
	}
}
