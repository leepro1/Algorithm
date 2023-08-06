/*
 * https://www.acmicpc.net/problem/2018
 * 연속된 자연수의 합
 * 투 포인터 알고리즘을 이용한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2018 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		int start = 1;
		int end = 1;
		int cnt = 1;
		int sum = 1;

		while (end != N) {
			if (sum == N) {
				cnt++;
				end++;
				sum += end;
			} else if (sum > N) {
				sum -= start;
				start++;
			} else {
				end++;
				sum += end;
			}
		}
		System.out.println(cnt);
	}
}
