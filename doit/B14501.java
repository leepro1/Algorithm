/*
 * https://www.acmicpc.net/problem/14501
 * 퇴사 
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14501 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 2]; //퇴사날까지 상담을 할 경우를 고려하여 n+2까지
		int[][] consult = new int[n + 1][2];

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			consult[i][0] = Integer.parseInt(st.nextToken());
			consult[i][1] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= n; i++) {
			dp[i] = Math.max(dp[i], dp[i - 1]);
			
			if (i + consult[i][0] <= n + 1)
				dp[i + consult[i][0]] = Math.max(dp[i + consult[i][0]], dp[i] + consult[i][1]);
		}

		System.out.println(Math.max(dp[n], dp[n + 1]));
	}
}
