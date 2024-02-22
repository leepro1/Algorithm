package swea;

//수행시간:2,154ms       메모리:113,336kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S3124 {
	static int E, V;
	static int[] parent;
	static Edge[] edgeList;

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
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			edgeList = new Edge[E];
			parent = new int[100_001];
			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int cost = Integer.parseInt(st.nextToken());

				edgeList[i] = new Edge(start, end, cost);
				parent[start] = start;
				parent[end] = end;
			}

			Arrays.sort(edgeList);

			int cnt = 0;
			long sum = 0;
			for (Edge e : edgeList) {
				if (union(e.start, e.end)) {
					sum += e.cost;
					if (++cnt == V - 1)
						break;
				}
			}

			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.println(sb);
	}

	static int find(int x) {
		if (x == parent[x])
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
