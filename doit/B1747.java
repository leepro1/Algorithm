/*
 * https://www.acmicpc.net/problem/1747
 * 소수&팰린드롬
 * 소수이면서 팰린드롬인 최솟값 구하기
 * 1부터 N까지 값 중 소수를 먼저 구하고 팰린드롬인 수를 찾자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1747 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		boolean[] checkArr = new boolean[1005000]; // 1000000 이후의 정답도 구해야하니 넉넉하게 잡자
		checkArr[1] = true;

		// 소수 찾기
		for (int i = 2; i * i <= checkArr.length; i++) {
			if (checkArr[i])
				continue;

			for (int j = i * 2; j <= checkArr.length - 1; j += i) {
				checkArr[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		// 소수 중 팰린드롬 수를 오름차순으로 찾다가 찾으면 종료
		for (int i = n; i < checkArr.length; i++) {
			if (checkArr[i])
				continue;

			// 팰린드롬 수 찾기
			sb.append(i);
			if (palindrome(sb)) {
				System.out.println(i);
				break;
			}
			sb.setLength(0);
		}
	}

	static boolean palindrome(StringBuilder sb) {
		int start = 0;
		int end = sb.length() - 1;

		while (start <= end) {
			if (sb.charAt(end) != sb.charAt(start))
				return false;
			start++;
			end--;
		}
		return true;
	}
}
