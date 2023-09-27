/*
 * https://www.acmicpc.net/problem/1916
 * 최소비용 구하기
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

public class B1916 {
	static ArrayList<Node>[] nodeList;
	static boolean[] visited;
	static int[] dist;

	static class Node implements Comparable<Node> {
		int nodeIndex;
		int cost;

		Node(int nodeIndex, int cost) {
			this.nodeIndex = nodeIndex;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 정점 수
		int m = Integer.parseInt(br.readLine()); // 간선 수

		nodeList = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<Node>();
		}

		Arrays.fill(dist, Integer.MAX_VALUE);

		StringTokenizer st;
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			nodeList[u].add(new Node(v, cost));
		}

		st = new StringTokenizer(br.readLine());
		int startNode = Integer.parseInt(st.nextToken());
		int endNode = Integer.parseInt(st.nextToken());

		dijkstra(startNode);

		System.out.println(dist[endNode]);
	}

	static void dijkstra(int startNode) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[startNode] = 0;
		pq.offer(new Node(startNode, 0));

		while (!pq.isEmpty()) {
			Node nowNode = pq.poll();

			if (!visited[nowNode.nodeIndex]) {
				visited[nowNode.nodeIndex] = true;

				for (Node nextNode : nodeList[nowNode.nodeIndex]) {
					if (!visited[nextNode.nodeIndex]
							&& dist[nextNode.nodeIndex] > dist[nowNode.nodeIndex] + nextNode.cost) {
						dist[nextNode.nodeIndex] = dist[nowNode.nodeIndex] + nextNode.cost;
						pq.offer(new Node(nextNode.nodeIndex, dist[nextNode.nodeIndex]));
					}
				}

			}
		}
	}
}
