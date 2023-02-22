//https://www.acmicpc.net/problem/2156..
//Top-down방식 풀이
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2156 {
	private static int[] arr;
	private static Integer[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		arr = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		dp = new Integer[n + 1];
		dp[0] = 0;
		dp[1] = arr[1];
		if (n != 1) {
			dp[2] = arr[1] + arr[2];
		}

		System.out.println(recur(n));
	}

	private static int recur(int N) {
		if (dp[N] == null) {
			dp[N] = Math.max(Math.max(recur(N - 2), recur(N - 3) + arr[N - 1]) + arr[N], recur(N - 1));
		}
		return dp[N];
	}
}
