/*
 * https://www.acmicpc.net/problem/11726
 * 2n 타일링
 * n-1까지 타일이 채워져 있거나 n-2까지 타일이 채워져 있는 조합 dp 문제이다.
 * n=1일때 주의하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11726 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[n + 1];

		dp[1] = 1;
		if (n > 1)
			dp[2] = 2;

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
		}

		System.out.println(dp[n]);
	}
}
