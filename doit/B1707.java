/*
 * https://www.acmicpc.net/problem/1707
 * 이분 그래프
 * 그래프를 탐색하여 이분할 되는지 판별한다. + 방향이 없다.
 * => 핵심은 사이클이 없어야한다는 것이다. (사이클은 최소 3개부터 생기므로)
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1707 {
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		while (k-- > 0) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			nodeList = new ArrayList[v + 1];
			visited = new boolean[v + 1];

			for (int i = 1; i <= v; i++) {
				nodeList[i] = new ArrayList<>();
			}

			while (e-- > 0) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				nodeList[x].add(y);
				nodeList[y].add(x);
			}

			int cnt = 0; // 분할 개수를 저장할 변수
			for (int i = 1; i <= v; i++) {
				if (!visited[i]) {
					bfs(i);
					cnt++;
				}
			}
			if (cnt == 2) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	static void bfs(int startNode) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(startNode);
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			int node = queue.poll();

			for (int nextNode : nodeList[node]) {
				if (!visited[nextNode]) {
					queue.offer(nextNode);
					visited[nextNode] = true;
				}
			}
		}
	}
}
