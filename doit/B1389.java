/*
 * https://www.acmicpc.net/problem/1389
 * 케빈 6법칙
 * 각 사람끼리 알게되는 최소 단계(거리)를 구하고 그 합이 가장 적은 사람을 찾는문제
 * 모든 사람 -> 다른 모든 사람과의 최소 거리이므로 플로이드 워셜로 풀자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1389 {
	static int[][] dist;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		dist = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 0 : 101;
			}
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			dist[u][v] = 1;
			dist[v][u] = 1;
		}

		floyd();

		int min = Integer.MAX_VALUE;
		int minIndex = 0;
		int sum;

		for (int i = 1; i <= n; i++) {
			sum = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == 101)
					continue;
				else
					sum += dist[i][j];
			}
			if (sum < min) {
				min = sum;
				minIndex = i;
			}
		}

		System.out.println(minIndex);
	}

	static void floyd() {
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
