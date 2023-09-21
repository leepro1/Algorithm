/*
 * https://www.acmicpc.net/problem/1929
 * 소수 구하기
 * 에라토스테네스의 체를 이용하자.
 * i는 n의 제곱수까지만 반복한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		boolean[] checkArr = new boolean[n + 1]; // 기본값이 false이니 소수를 false라고 하자

		for (int i = 2; i * i <= n; i++) {
			if (checkArr[i])
				continue;
			for (int j = i * 2; j <= n; j += i) {
				checkArr[j] = true;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = m; i <= n; i++) {
			if (i == 1)
				continue;
			if (!checkArr[i])
				sb.append(i + "\n");
		}

		System.out.println(sb);
	}
}
