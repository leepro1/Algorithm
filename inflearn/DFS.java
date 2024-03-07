package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DFS {
	public static int V, E;
	public static boolean[] visited;
	public static LinkedList<Integer>[] nodeList;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken()); // 정점의 개수
		int E = Integer.parseInt(st.nextToken()); // 간선의 개수

		// 각 정점별로 인접한 정점리스트를 만든다.
		nodeList = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}

		// 간선 입력받기
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			nodeList[node1].add(node2);
			nodeList[node2].add(node1);

			// 같은 레벨(깊이)일 때 낮은 숫자를 먼저 탐색하기로 하자
			Collections.sort(nodeList[node1]);
			Collections.sort(nodeList[node2]);
		}

		visited = new boolean[V + 1];

        dfs(1);

		System.out.println(sb);
	}

	public static void dfs(int node) {
		visited[node] = true;
		sb.append(node + " ");

		for (int nextNode : nodeList[node]) {
			if (!visited[nextNode])
				dfs(nextNode);
		}
	}
}
