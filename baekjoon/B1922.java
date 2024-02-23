package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1922 {
	static int N, M;
	static int[] parent;
	static PriorityQueue<Edge> edgeList = new PriorityQueue<>();

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
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
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			edgeList.add(new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken())));
		}

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		int cnt = 0;
		int sum = 0;
		while (!edgeList.isEmpty()) {
			Edge edge = edgeList.poll();

			if (union(edge.start, edge.end)) {
				sum += edge.cost;
				if (++cnt == N - 1)
					break;
			}
		}

		System.out.println(sum);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x == y)
			return false;

		if (x <= y)
			parent[y] = x;

		else
			parent[x] = y;

		return true;
	}
}
