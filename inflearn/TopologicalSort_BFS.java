package inflearn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TopologicalSort_BFS {

	public static int V, E;
	public static int[] inDegree;
	public static LinkedList<Integer>[] nodeList;
	public static LinkedList<Integer> result = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수

		// 각 정점별로 다음 방향의 정점리스트를 만든다.
		nodeList = new LinkedList[V + 1];
		for (int i = 1; i <= V; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}

		// 간선 입력받으며 inDegree 체크해주기
		inDegree = new int[V + 1];
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());

			nodeList[from].add(to);
			inDegree[to]++;
		}

		topologicalSort();

		for (int node : result) {
			System.out.print(node + " ");
		}
	}

	public static void topologicalSort() {
		Queue<Integer> queue = new ArrayDeque<>();

		// 진입차수가 0인(선행 노드가 없는) 노드를 queue에 넣는다.
		for (int i = 1; i <= V; i++) {
			if (inDegree[i] == 0)
				queue.add(i);
		}

		while (!queue.isEmpty()) {
			int node = queue.poll();
			result.add(node); // 출력을 위한 값

			for (int next : nodeList[node]) {
				if (--inDegree[next] == 0)
					queue.add(next);
			}
		}
	}
}
