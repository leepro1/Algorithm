/*
 * 베르트랑 공준 - 소수알고리즘
 * 에라토스테네스의 체를 이용하여 풀어보자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B4948 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		while (true) {
			int N = Integer.parseInt(br.readLine());

			if (N == 0)
				break;

			boolean[] prime = new boolean[2 * N + 1]; // 소수를 체크할 배열

			prime[0] = prime[1] = true;

			for (int i = 0; i <= Math.sqrt(2 * N); i++) {
				if (prime[i] == true) {
					continue;
				}

				// 배수 제외
				for (int j = i * i; j < prime.length; j = j + i) {
					prime[j] = true;
				}
			}

			int cnt = 0;

			for (int i = N + 1; i <= 2 * N; i++) {
				if (prime[i] == false) {
					cnt++;
				}
			}
			sb.append(cnt).append("\n");
		}

		System.out.println(sb);
	}

}