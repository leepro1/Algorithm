package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//수행시간: 132ms       메모리: 14,516kb
public class B1149 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] input = new int[3][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			input[0][i] = Integer.parseInt(st.nextToken());
			input[1][i] = Integer.parseInt(st.nextToken());
			input[2][i] = Integer.parseInt(st.nextToken());
		}

		int[][] dp = new int[3][N];
		dp[0][0] = input[0][0];
		dp[1][0] = input[1][0];
		dp[2][0] = input[2][0];

		for (int i = 1; i < N; i++) {
			dp[0][i] = Math.min(dp[1][i - 1], dp[2][i - 1]) + input[0][i];
			dp[1][i] = Math.min(dp[0][i - 1], dp[2][i - 1]) + input[1][i];
			dp[2][i] = Math.min(dp[0][i - 1], dp[1][i - 1]) + input[2][i];
		}

		System.out.println(Math.min((Math.min(dp[0][N - 1], dp[1][N - 1])), dp[2][N - 1]));
	}
}
