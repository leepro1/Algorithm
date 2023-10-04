/*
 * https://www.acmicpc.net/problem/11725
 * 트리의 부모 찾기
 * i=1 부터 n까지의 순서로 부모노드를 구하다 보니 부모가 바뀌어야하는 에러가 생김
 * 이를 해결하기 위해 부모가 생기면 그 노드부터 탐색해야함 즉 dfs
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B11725 {
	static int[] parent;
	static ArrayList<Integer>[] nodeList;
	static boolean[] visited;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		parent = new int[n + 1];
		nodeList = new ArrayList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			nodeList[x].add(y);
			nodeList[y].add(x);
		}

		makeTree(1);

		StringBuilder sb = new StringBuilder();
		for (int answer : parent) {
			if (answer == 0)
				continue;
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}

	// dfs 방식
	static void makeTree(int start) {
		visited[start] = true;

		for (int node : nodeList[start])
			if (!visited[node]) {
				parent[node] = start;
				makeTree(node);
			}
	}
}
