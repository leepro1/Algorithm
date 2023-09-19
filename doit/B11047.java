/*
 * https://www.acmicpc.net/problem/11047
 * 동전0
 * 그리디 알고리즘으로 풀었다. 동전1, 동전2 등의 문제도 풀어보자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11047 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int money = Integer.parseInt(st.nextToken());

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		int cnt = 0;
		for (int i = n - 1; i >= 0; i--) {
			if (money / arr[i] > 0) {
				cnt += money / arr[i];
				money %= arr[i];
			}
		}
		System.out.println(cnt);
	}
}
