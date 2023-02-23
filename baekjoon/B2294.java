//https://www.acmicpc.net/problem/2294
/*
 * 동전2 - dp
 * 주어진 동전의 가치를 이용하여 최소 개수를 사용하여 k원을 만든다.
 * 동전의 가치를 변경해가며 그 가치를 만들 수 있는 최소 개수를 갱신해간다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B2294 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int[] coin = new int[n + 1];
		int[] dp = new int[k + 1];

		Arrays.fill(dp, 100001); //최대 가능 가치는 100000
		dp[0]=0;
		
		for (int i = 0; i < n; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < n; i++) {
			for (int j = coin[i]; j <= k; j++) {
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
			}
		}
		
		if (dp[k] == 100001)
			System.out.println(-1);
		else
			System.out.println(dp[k]);
	}
}
