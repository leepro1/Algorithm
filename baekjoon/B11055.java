//https://www.acmicpc.net/problem/11055
/*
 * 가장 큰 증가하는 부분 수열 - dp
 * 증가하는 부분 수열중 합이 가장 큰 것을 찾는다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11055 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n];
		int[] seq = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}

		dp[0] = seq[0];

		for (int i = 1; i < n; i++) {
			dp[i]=seq[i];
			
			for (int j = 0; j < i; j++) {
				if (seq[i] > seq[j]) {
					dp[i] = Math.max(dp[i], dp[j] + seq[i]);
				}
			}
		}

		int max = dp[0];

		for (int i = 1; i < n; i++) {
			max = Math.max(max, dp[i]);
		}

		System.out.println(max);
	}
}
