/*
 * https://www.acmicpc.net/problem/11659
 * 구간 합
 * 구간 합을 구하기 위해 합배열을 먼저 구한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] num = new int[N + 1];
		int[] sum = new int[N + 1]; // 구간합을 위한 합배열
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			sum[i] = (i == 1) ? num[i] : num[i] + sum[i - 1];
		}

		int start, end;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			System.out.println(sum[end] - sum[start - 1]);
		}
	}
}
