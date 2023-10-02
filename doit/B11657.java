/*
 * https://www.acmicpc.net/problem/11657
 * 타임머신으로 빨리가기
 * 가중치가 음수가 있는 최단거리 구하기 이므로 벨만포드 알고리즘을 사용한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11657 {
	static Edge[] edgeList;
	static long[] dist;
	static int n, m;

	static class Edge {
		int start;
		int end;
		int weight;

		Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		edgeList = new Edge[m];
		dist = new long[n + 1];

		Arrays.fill(dist, Long.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			edgeList[i] = new Edge(start, end, weight);
		}

		boolean possible = bellmanFord(1);

		if (possible) {
			StringBuilder sb = new StringBuilder();

			for (int i = 2; i < dist.length; i++) {
				if (dist[i] == Long.MAX_VALUE)
					sb.append(-1 + "\n");
				else
					sb.append(dist[i] + "\n");
			}
			System.out.println(sb);
		} else {
			System.out.println(-1);
		}
	}

	static boolean bellmanFord(int start) {
		dist[start] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				Edge edge = edgeList[j];

				if (dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
					dist[edge.end] = dist[edge.start] + edge.weight;
				}
			}
		}

		// 음수 사이클 확인
		for (int i = 0; i < m; i++) {
			Edge edge = edgeList[i];

			// 최단 경로로 만든 dist보다 더 작아지면 음수 사이클이 존재한다.
			if (dist[edge.start] != Long.MAX_VALUE && dist[edge.end] > dist[edge.start] + edge.weight) {
				return false;
			}
		}
		return true;
	}
}
