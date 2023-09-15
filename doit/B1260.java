/*
 * https://www.acmicpc.net/problem/1260
 * DFS와 BFS
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {
	static LinkedList<Integer>[] nodeList;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());

		visited = new boolean[n + 1];
		nodeList = new LinkedList[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nodeList[x].add(y);
			nodeList[y].add(x);

			Collections.sort(nodeList[x]);
			Collections.sort(nodeList[y]);
		}

		dfs(v);

		sb.append("\n");
		visited = new boolean[n + 1];

		bfs(v);

		System.out.println(sb);
	}

	static void dfs(int node) {
		visited[node] = true;
		sb.append(node + " ");

		for (int i : nodeList[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}

	static void bfs(int node) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(node);

		while (!queue.isEmpty()) {
			node = queue.poll();

			if (visited[node])
				continue;

			visited[node] = true;
			sb.append(node + " ");

			for (int nextNode : nodeList[node]) {
				queue.add(nextNode);
			}

		}
	}
}
