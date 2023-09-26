/*
 * https://www.acmicpc.net/problem/2252
 * 줄 세우기
 * 위상 정렬 알고리즘을 구현해보자.
 * degree는 선행되어야하는 작업의 수
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2252 {
	static ArrayList<Integer>[] nodeList;
	static int[] degree;
	static int n;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		nodeList = new ArrayList[n + 1];
		degree = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodeList[a].add(b);
			degree[b]++;
		}

		topologySort();
		System.out.println(sb);
	}

	static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}

		for (int i = 1; i <= n; i++) {
			int x = queue.poll();
			sb.append(x + " ");

			for (int next : nodeList[x]) {
				if (--degree[next] == 0)
					queue.offer(next);
			}
		}
	}
}
