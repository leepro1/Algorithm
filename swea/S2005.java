package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class S2005 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		int[][] dp = new int[11][11];

		for (int i = 0; i <= 10; i++) {
			dp[i][0] = 1;
			for (int j = 1; j <= i; j++) {
				dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int k = 1; k <= t; k++) {
			sb.setLength(0);
			int n = Integer.parseInt(br.readLine());
			sb.append("#" + k + "\n");

			for (int i = 0; i < n; i++) {
				for (int j = 0; j <= i; j++) {
					sb.append(dp[i][j] + " ");
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}
	}
}