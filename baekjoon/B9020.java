//https://www.acmicpc.net/problem/9020
/*
 * 골드바흐의 추측 - 정수론, 소수알고리즘
 * 2보다 큰 짝수는 두 소수의 합으로 나타낼 수 있다는 골드바흐의 추측문제이다
 * 소수를 저장하는 배열을 하나 생성하여 n이 주어질 때 마다 작은 소수부터 시작하여 다른 소수와의 합이 n이 되는지 찾아본다
 * 골드바흐 파티션(두 소수)을 찾을때에는 n/2까지만 찾고 그 범위내에서 새로운 파티션을 찾을 시 앞에서 찾을 값과 교체한다
 * 소수를 구할 때는 에라토스테네스의 체를 이용하자
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B9020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		// 10000까지의 소수를 구한다
		boolean[] prime = new boolean[10001];
		prime[0] = prime[1] = true;

		for (int i = 0; i <= Math.sqrt(prime.length); i++) {
			if (prime[i] == true) {
				continue;
			}

			// 배수 제외
			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}

		// 테스트케이스를 입력받아 골드바흐 파티션을 구한다
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int firstPart = 0;
			int secondPart = 0;

			for (int i = 2; i <= n / 2; i++) {
				if (prime[i] == true)
					continue;
				else if (prime[n - i] == false) {
					firstPart = i;
					secondPart = n - i;
				}
			}
			sb.append(firstPart + " " + secondPart).append("\n");
		}

		System.out.println(sb);
	}
}
