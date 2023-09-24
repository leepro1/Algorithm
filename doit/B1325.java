/*
 * https://www.acmicpc.net/problem/1325
 * 효율적인 해킹
 * 연결된 노드의 개수가 최대인 노드를 구하는 문제 DFS 또는 BFS를 쓰자
 * 방향이 있다.
 * + 그래프 탐색할 때 nodeList는 ArrayList를 사용하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1325 {
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[n + 1];
		answer = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodeList[b].add(a);
		}

		int max = 0;
		for (int i = 1; i <= n; i++) {
			visited = new boolean[n+1];
			bfs(i);
			
			if (answer[i] > max)
				max = answer[i];
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			if (answer[i] == max)
				sb.append(i + " ");
		}
		System.out.println(sb);
	}

	static void bfs(int nowNode) {
		Queue<Integer> queue = new LinkedList<>();

		queue.offer(nowNode);
		visited[nowNode] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int temp : nodeList[node]) {
				if (!visited[temp]) {
					queue.offer(temp);
					visited[temp] = true;
					answer[nowNode]++;
				}
			}
		}
	}
}
