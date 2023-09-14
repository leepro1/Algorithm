/*
 * https://www.acmicpc.net/problem/11724
 * 연결 요소의 개수 구하기
 * 방향없는 그래프의 dfs를 구현하자
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B11724 {
	private static LinkedList<Integer>[] nodeList;
	private static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodeList = new LinkedList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			nodeList[u].add(v);
			nodeList[v].add(u);
		}

		int cnt = 0;

		for (int i = 1; i <= n; i++) {
			if (!visited[i]) {
				dfs(i);
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	static void dfs(int node) {
		visited[node] = true;

		for (int i : nodeList[node]) {
			if (!visited[i]) {
				dfs(i);
			}
		}
	}
}
