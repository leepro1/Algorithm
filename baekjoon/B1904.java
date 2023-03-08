//https://www.acmicpc.net/problem/1904
/*
 * 01타일 - dp
 * top-down (재귀)방식으로 그자리르 채워간다. 
 * 오버플로우에러 - n이 1일때도 생각했자.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1904 {
	private static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		}
		dp = new int[n + 1];

		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;

		System.out.println(CountTile(n));
	}

	private static int CountTile(int n) {
		if (dp[n] == 0) {
			dp[n] = (CountTile(n - 1) + CountTile(n - 2)) % 15746;
		}

		return dp[n];
	}
}