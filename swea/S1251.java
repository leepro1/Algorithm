package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//수행시간: 324ms       메모리:85,640kb
public class S1251 {
	static int[] parent;
	static double E;

	static class Vertax {
		int start;
		int end;

		public Vertax(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

	static class Edge {
		int start;
		int end;
		long cost;

		public Edge(int start, int end, long cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		Vertax[] nodeList;
		PriorityQueue<Edge> edgeList;
		int[] xList, yList;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(br.readLine());

			nodeList = new Vertax[N];
			edgeList = new PriorityQueue<>(Comparator.comparingLong(o -> (long) o.cost));
			xList = new int[N];
			yList = new int[N];
			parent = new int[N];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				xList[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				yList[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				nodeList[i] = new Vertax(xList[i], yList[i]);
				parent[i] = i;
			}

			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					edgeList.add(new Edge(i, j, calCost(nodeList[i], nodeList[j])));
				}
			}

			int cnt = 0;
			long sum = 0;

			while (!edgeList.isEmpty()) {
				Edge e = edgeList.poll();
				
				if (union(e.start, e.end)) {
					sum += e.cost;
					if (++cnt == N - 1)
						break;
				}
			}

			E = Double.parseDouble(br.readLine());
			// 출력부
			sb.append("#" + test_case + " " + Math.round(E * sum) + "\n");
		}
		System.out.println(sb);

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

	static long calCost(Vertax i, Vertax j) {
		return (long) (Math.pow(Math.abs(i.start - j.start), 2) + Math.pow(Math.abs(i.end - j.end), 2));
	}
}
