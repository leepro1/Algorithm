/*
 * https://www.acmicpc.net/problem/1197
 * 최소 스패닝 트리(MST)
 * edgeList를 가중치 오름차순으로 만들어 크루스칼 알고리즘을 사용해보자
 * 사이클 검사는 union-find를 이용한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1197 {
	static PriorityQueue<Edge> edgePQ;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		edgePQ = new PriorityQueue<>();
		parent = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			parent[i] = i;
		}

		while (e-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			edgePQ.offer(new Edge(v1, v2, cost));
		}

		System.out.println(mst());
	}

	static int mst() {
		int sumCost = 0;

		while (!edgePQ.isEmpty()) {
			Edge edge = edgePQ.poll();

			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);
				sumCost += edge.cost;
			}
		}

		return sumCost;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}
}
