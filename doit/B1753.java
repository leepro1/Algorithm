/*
 * https://www.acmicpc.net/problem/1753
 * 최단 경로 구하기
 * 최소비용(최단거리) + 양수 가중치 이므로 다익스트라 알고리즘으로 풀자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1753 {
	static ArrayList<Node>[] nodeList;
	static boolean[] visited;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int nextNode;
		int weight;

		Node(int nextNode, int weight) {
			this.nextNode = nextNode;
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

		int v = Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(br.readLine()); // 시작 노드

		nodeList = new ArrayList[v + 1];
		visited = new boolean[v + 1];
		dist = new int[v + 1];

		for (int i = 1; i <= v; i++) {
			nodeList[i] = new ArrayList<>();
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		while (e-- > 0) {
			st = new StringTokenizer(br.readLine());
			int startNode = Integer.parseInt(st.nextToken());
			int nextNode = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			nodeList[startNode].add(new Node(nextNode, weight));
		}

		dijkstra(k);

		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF").append("\n");
			else
				sb.append(dist[i]).append("\n");
		}
		System.out.println(sb);
	}

	static void dijkstra(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(startNode, 0));
		dist[startNode] = 0;

		while (!pq.isEmpty()) {
			Node tempNode = pq.poll();

			if (!visited[tempNode.nextNode]) {
				visited[tempNode.nextNode] = true;

				for (Node node : nodeList[tempNode.nextNode]) {
					if (!visited[node.nextNode] && dist[node.nextNode] > dist[tempNode.nextNode] + node.weight) {
						dist[node.nextNode] = dist[tempNode.nextNode] + node.weight;
						pq.offer(new Node(node.nextNode, dist[node.nextNode]));
					}
				}
			}
		}

	}
}