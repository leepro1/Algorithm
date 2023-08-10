/*
 * https://www.acmicpc.net/problem/1940
 * 주몽의 망령
 * 정렬을 해야해서 투 포인터 알고리즘을 사용안함
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		int[] material = new int[100001];
		int cnt = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (st.hasMoreTokens()) {
			int num = Integer.parseInt(st.nextToken());
			if (num > M)
				continue;
			else if (num > M / 2) {
				if (material[M - num] == 1) {
					material[M - num] = 0;
					cnt++;
				} else {
					material[M - num]++;
				}
			} else {
				if (material[num] == 1) {
					material[num] = 0;
					cnt++;
				} else {
					material[num]++;
				}
			}
		}

		System.out.println(cnt);
	}
}
