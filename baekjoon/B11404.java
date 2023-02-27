//https://www.acmicpc.net/problem/11404
/*
 * 플로이드 - 플로이드 워셜
 * 플로이드 워셜 알고리즘은 dp를 기반으로 인접행렬을 이용하여 사용하는 방식이다.
 * 하나의 정점이 아닌 모든 정점에서의 최단거리를 구할 수 있다.
 * Integer.MAX_VALUE는 거리를 갱신할 때 오버플로우가 난다.
 * 그리고 거리는 n(100) x m(100000)은 넘어주어야 최악의 경우도 처리할 수 있다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine()); // 정점
		int m = Integer.parseInt(br.readLine()); // 간선

		int[][] dist = new int[n + 1][n + 1]; // 거리테이블

		// 거리 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 0 : 10000001;
			}
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 정점
			int b = Integer.parseInt(st.nextToken()); // 간선
			int c = Integer.parseInt(st.nextToken()); // 가중치

			dist[a][b] = Math.min(dist[a][b], c); // 경로가 하나가 아니다.
		}

		// 최단 거리 갱신
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}

		// 출력
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == 10000001) // 경로가 없을 때
					System.out.print(0 + " ");
				else
					System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}

	}
}
