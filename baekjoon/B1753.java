//https://www.acmicpc.net/problem/1753
/*
 * 최단경로 - 다익스트라
 * 다익스트라 알고리즘을 이용하여 각 정점까지의 최단거리(가중치합)를 출력한다.
 * 최단거리를 저장한 배열 dist의 값이 Integer.MAX_VALUE이면 INF를 출력한다.
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	private static int V, E;
	private static LinkedList<Node>[] nodeList;
	private static int[] dist; // 최단거리를 저장할 배열
	private static boolean[] visited; // 방문여부

	private static class Node implements Comparable<Node> {
		int end;
		int weight;

		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		int K = Integer.parseInt(br.readLine());

		nodeList = new LinkedList[V + 1];
		dist = new int[V + 1];
		visited = new boolean[V + 1];

		Arrays.fill(dist, Integer.MAX_VALUE); // 최초거리는 무한대

		for (int i = 0; i <= V; i++) {
			nodeList[i] = new LinkedList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList[node1].add(new Node(node2, weight));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= V; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node tempNode = pq.poll();

			if (!visited[tempNode.end]) {
				visited[tempNode.end] = true;

				// 최단 거리 갱신
				for (Node node : nodeList[tempNode.end]) {
					if (!visited[node.end] && dist[node.end] > dist[tempNode.end] + node.weight) {
						dist[node.end] = dist[tempNode.end] + node.weight;

						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
	}
}
