/*
 * https://www.acmicpc.net/problem/11404
 * 플로이드
 * 모든 노드에서 다른 노드들간에 최단 거리를 구해야한다. 플로이드 워셜 알고리즘을 사용하자.
 * 입력을 받을 때 같은 노선 다른 cost를 주의하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B11404 {
	static int[][] dist;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		dist = new int[n + 1][n + 1];

		// 거리 초기화
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 0 : 100001;
			}
		}

		StringTokenizer st;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			// 같은 노선 다른 cost가 있다
			dist[start][end] = Math.min(dist[start][end], cost);
		}

		floyd();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] == 100001)
					sb.append(0 + " ");
				else
					sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}

		System.out.println(sb);
	}

	static void floyd() {
		// 최단 거리 갱신
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}
}
