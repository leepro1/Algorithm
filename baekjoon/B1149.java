//https://www.acmicpc.net/problem/1149
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		// 행과열을 뒤집어서 dp계산을 생각하기 쉽게하였다.
		int[][] arr = new int[3][n];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] dp = new int[3][n];
		dp[0][0] = arr[0][0];
		dp[1][0] = arr[1][0];
		dp[2][0] = arr[2][0];

		for (int i = 1; i < n; i++) {
			dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + arr[0][i];
			dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + arr[1][i];
			dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + arr[2][i];
		}

		System.out.println(Math.min(Math.min(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]));
	}
}
