/*
 * https://www.acmicpc.net/problem/1516
 * 게임개발하기
 * 순서가 정해진 작업이므로 위상정렬을 이용한다. + 동시에 지을 수 있다는 것을 고려
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1516 {
	static ArrayList<Integer>[] nodeList;
	static int[] degree;
	static int[] buildTime;
	static int[] result;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		nodeList = new ArrayList[n + 1];
		degree = new int[n + 1];
		buildTime = new int[n + 1];
		result = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new ArrayList<>();
		}

		StringTokenizer st;
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			buildTime[i] = Integer.parseInt(st.nextToken());

			while (true) {
				int preBuilding = Integer.parseInt(st.nextToken());
				if (preBuilding == -1)
					break;
				nodeList[preBuilding].add(i);
				degree[i]++;
			}
		}

		topologySort();

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(result[i] + buildTime[i] + "\n");
		}
		System.out.println(sb);
	}

	static void topologySort() {
		Queue<Integer> queue = new LinkedList<>();

		for (int i = 1; i <= n; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}

		while (!queue.isEmpty()) {
			int temp = queue.poll();

			for (int node : nodeList[temp]) {
				result[node] = Math.max(result[node], result[temp] + buildTime[temp]);
				if (--degree[node] == 0)
					queue.offer(node);
			}
		}
	}
}
