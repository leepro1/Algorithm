/*
 * LIS(최장부분수열) 알고리즘이다.
 * dp를 이용하고 시간복잡도는 O(n^2)이다.
 */
package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LIS_dp {
	static int[] dp, seq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		dp = new int[n];
		seq = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i < n; i++) {
			LIS(i);
		}

		int max = dp[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}

	private static int LIS(int n) {

		if (dp[n] == 0)
			dp[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			if (seq[n] > seq[i])
				dp[n] = Math.max(dp[n], LIS(i) + 1);
		}

		return dp[n];
	}
}
