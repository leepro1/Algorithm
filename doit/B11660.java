/*
 * https://www.acmicpc.net/problem/11660
 * 구간 합2
 * 구간 합을 구하기 위해 합배열을 먼저 구한다.
 * 계산을 편하게 하기 위해 입력배열과 합배열의 크기를 +1 한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11660 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] num = new int[N + 1][N + 1];
		int[][] sum = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			sum[i][0] = 0;
			for (int j = 1; j <= N; j++) {
				num[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i][j - 1] + num[i][j];

			}
		}

		int x1, y1, x2, y2;
		StringBuilder sb = new StringBuilder();
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			x1 = Integer.parseInt(st.nextToken());
			y1 = Integer.parseInt(st.nextToken());
			x2 = Integer.parseInt(st.nextToken());
			y2 = Integer.parseInt(st.nextToken());

			int result = 0;
			for (int i = x1; i <= x2; i++) {
				result += sum[i][y2] - sum[i][y1 - 1];
			}
			sb.append(result + "\n");
		}
		System.out.println(sb);
	}
}
