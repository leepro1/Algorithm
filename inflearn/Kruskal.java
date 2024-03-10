package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Kruskal {
	static int V, E;
	static int[] parent;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			pq.add(new Edge(start, end, weight));
		}

		makeSet();

		int cnt = 0;
		int totalWeight = 0;
		while (!pq.isEmpty()) {
			Edge edge = pq.poll();

			if (union(edge.start, edge.end)) {
				totalWeight += edge.weight;
				System.out.println(edge.start + "-" + edge.end + "연결, 누적 weight: " + totalWeight);

				if (++cnt == V - 1)
					break;
			}
		}
	}

	public static void makeSet() {
		parent = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	public static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		// 사이클 검사를 위해 변형
		if (x == y)
			return false;

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;

		return true;
	}
}
