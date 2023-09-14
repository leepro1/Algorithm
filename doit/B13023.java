/*
 * https://www.acmicpc.net/problem/13023
 * 친구관계 파악하기
 * 모든 노드를 시작노드로 하여 탐색해봐야하기 때문에
 * dfs 재귀를 하고 돌아올 때 visited[node] = false;을 해주는 것이 핵심이다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B13023 {
	static final int MAX_COUNT = 5;
	static LinkedList<Integer>[] nodeList;
	static boolean[] visited;
	static boolean check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodeList = new LinkedList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodeList[a].add(b);
			nodeList[b].add(a);
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(i, 1);
				if (check)
					break;
			}
		}
		System.out.println(check ? 1 : 0);
	}

	public static void dfs(int node, int depth) {
		if (depth == MAX_COUNT || check) {
			check = true;
			return;
		}

		visited[node] = true;

		for (int i : nodeList[node]) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[node] = false;
	}
}
