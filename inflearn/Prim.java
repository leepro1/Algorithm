package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Prim {
	static int V, E;
	static boolean[] visited;
	static int[] minEdge;
	static ArrayList<Vertex>[] nodeList;

	static class Vertex implements Comparable<Vertex> {
		int no;
		int weight;

		public Vertex(int no, int weight) {
			this.no = no;
			this.weight = weight;
		}

		@Override
		public int compareTo(Vertex o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[V + 1];
		visited = new boolean[V + 1];
		minEdge = new int[V + 1];
		for (int i = 1; i <= V; i++) {
			nodeList[i] = new ArrayList<>();
			minEdge[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList[start].add(new Vertex(end, weight));
			nodeList[end].add(new Vertex(start, weight));
		}

		PriorityQueue<Vertex> pq = new PriorityQueue<>();
		minEdge[1] = 0;
		pq.offer(new Vertex(1, minEdge[1]));

		int cnt = 0;
		int totalWeight = 0;
		while (!pq.isEmpty()) {
			Vertex vertex = pq.poll();

			if (!visited[vertex.no]) {

				totalWeight += vertex.weight;
				visited[vertex.no] = true;
				System.out.println(vertex.no + ", 누적 weight: " + totalWeight);
				System.out.println(Arrays.toString(minEdge));
				
				for (Vertex next : nodeList[vertex.no]) {
					if (!visited[next.no] && minEdge[next.no] > next.weight) {
						minEdge[next.no] = next.weight;
						pq.offer(new Vertex(next.no, minEdge[next.no]));
					}
				}

				if (++cnt == V)
					break;
			}
		}
	}
}