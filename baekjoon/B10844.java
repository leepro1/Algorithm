//https://www.acmicpc.net/problem/10844
/*
 * 쉬운 계단 수 - dp
 * n의 자리수를 전부 조사하여 각 자리의 수의 인접한 부분이 1인 계단 수를 찾는것이다.
 * n의 자리수를 모두 조사한는 것은 비효율적이다 -> 
 * dp배열은 재귀로 했을 때 반복되는 것들을 기억하는 배열인데
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10844 {
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		
		long[][] dp = new long[n + 1][10];

		dp[1][0] = 0;
		dp[1][1] = dp[1][2] = dp[1][3] = dp[1][4] = dp[1][5] = dp[1][6] = dp[1][7] = dp[1][8] = dp[1][9] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				if (j == 0) {
					dp[i][j] = dp[i - 1][1];
				} else if (j == 9) {
					dp[i][j] = dp[i - 1][8];
				} else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
			}
		}

		long sum = 0;
		for (int i = 0; i < 10; i++) {
			sum += dp[n][i];
		}

		System.out.println(sum % 1000000000);
	}
	
}
