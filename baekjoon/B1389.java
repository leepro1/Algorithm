//https://www.acmicpc.net/problem/1389
/*
 * 케빈 베이컨의 6단계 법칙 - 그래프, 플로이드 워셜
 * 플로이드 워셜 알고리즘은 dp를 기반으로 인접행렬을 이용하여 사용하는 방식이다.
 * 하나의 정점이 아닌 모든 정점에서의 최단거리를 구할 수 있다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1389 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 정점
		int m = Integer.parseInt(st.nextToken()); // 간선

		int[][] dist = new int[n + 1][n + 1]; // 거리테이블

		// 거리 초기화
		for (int i = 1; i < n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 0 : Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()); // 정점
			int y = Integer.parseInt(st.nextToken()); // 간선

			dist[x][y] = 1;
			dist[y][x] = 1;
		}

		// 최단 거리 갱신
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i < n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		int[] kevinNum = new int[n + 1];
		int min = Integer.MAX_VALUE;

		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = 1; j <= n; j++) {
				sum += dist[i][j];
			}

			kevinNum[i] = sum;

			if (sum < min) {
				min = sum;
			}
		}

		for (int i = 1; i <= n; i++) {
			if (kevinNum[i] == min) {
				System.out.println(i);
				return;
			}
		}

	}
}
