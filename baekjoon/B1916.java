//https://www.acmicpc.net/problem/1916
/*
 * 최소비용 구하기 - 다익스트라
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1916 {
	private static int N, M;
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

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		nodeList = new LinkedList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE); // 최초거리는 무한대

		for (int i = 0; i <= N; i++) {
			nodeList[i] = new LinkedList<>();
		}

		StringTokenizer st;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList[node1].add(new Node(node2, weight));
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		System.out.println(dijkstra(start, end));
	}

	public static int dijkstra(int start, int end) {
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
		return dist[end];
	}
}
