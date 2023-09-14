/*
 * https://www.acmicpc.net/problem/2023
 * 신기한 소수
 * 소수가 아니면 탐색을 중단하는 dfs를 만들었다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2023 {
	static StringBuilder sb = new StringBuilder();
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		findAnswer(2,1);
		findAnswer(3,1);
		findAnswer(5,1);
		findAnswer(7,1);
		
		System.out.println(sb);
	}

	public static void findAnswer(int num, int digitCnt) {
		if (digitCnt==n && isPrime(num)) {
			sb.append(num+"\n");
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (isPrime(num)) {
				findAnswer(num * 10 + i, digitCnt+1);
			}
		}
	}

	public static boolean isPrime(int num) {
		for (int i = 2; i <= num / 2; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

}
