/*
 * https://www.acmicpc.net/problem/18352
 * 특정 거리의 도시 찾기
 * bfs문제이다. 방향이 있고 시작노드도 준다.
 * node의 depth를 어떤식으로 저장해야할지 몰라 아쉽게 풀었다.
 * visited를 int로 구현하여 depth를 저장하면 더 효율적이게 풀 수 있다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B18352 {
	static LinkedList<Integer>[] nodeList;
	static boolean[] visited;
	static LinkedList<Integer> answer = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()); // 거리 정보
		int x = Integer.parseInt(st.nextToken()); // 시작 도시

		nodeList = new LinkedList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			nodeList[i] = new LinkedList<Integer>();
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			nodeList[a].add(b);
		}

		bfs(x, k);

		StringBuilder sb = new StringBuilder();
		if (answer.isEmpty()) {
			System.out.println(-1);
		} else {
			Collections.sort(answer);
			for (int answerNode : answer) {
				sb.append(answerNode + "\n");
			}
			System.out.println(sb);
		}
	}

	static void bfs(int startNode, int depth) {
		Queue<NodeInfo> queue = new LinkedList<>();

		queue.offer(new NodeInfo(startNode, 0));
		visited[startNode] = true;

		while (!queue.isEmpty()) {
			NodeInfo node = queue.poll();

			if (node.nowDepth == depth) {
				answer.add(node.nowNode);
				continue;
			}

			for (int temp : nodeList[node.nowNode]) {
				if (!visited[temp]) {
					visited[temp] = true;
					queue.offer(new NodeInfo(temp, node.nowDepth + 1));
				}
			}
		}
	}

	static class NodeInfo {
		int nowNode;
		int nowDepth;

		NodeInfo(int nowNode, int nowDepth) {
			this.nowNode = nowNode;
			this.nowDepth = nowDepth;
		}
	}
}
