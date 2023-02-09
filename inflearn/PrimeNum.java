/*
 * N이하의 소수를 구하는 알고리즘 - 에라토스테네스의 체
 * k=2 부터 √N 이하까지 반복하여 자연수들 중 k의 배수들을 제거(k는 포함)
 */
package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		boolean[] prime = new boolean[N + 1]; // 소수를 체크할 배열

		prime[0] = prime[1] = true;

		for (int i = 2; i <= Math.sqrt(N); i++) {

			if (prime[i] == true) {
				continue;
			}

			// 배수 제외
			for (int j = i * i; j < prime.length; j = j + i) {
				prime[j] = true;
			}
		}

		for (int i = 0; i < prime.length; i++) {
			if (prime[i] == false) { // 소수(false)일 경우 출력
				System.out.println(i);
			}
		}
	}
}
