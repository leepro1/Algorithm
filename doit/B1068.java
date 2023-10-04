/*
 * https://www.acmicpc.net/problem/1068
 * 리프노드 개수 구하기
 * 자식 노드를 저장하는 ArrayList를 만들자.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class B1068 {
	static LinkedList<Integer>[] childNodeList;
	static int[] cntChild;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		childNodeList = new LinkedList[n];
		cntChild = new int[n];

		for (int i = 0; i < n; i++) {
			childNodeList[i] = new LinkedList<>();
		}

		StringTokenizer st = new StringTokenizer(br.readLine());
		int removeNode = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			int parentNode = Integer.parseInt(st.nextToken());

			// 제거될 노드는 부모를 지정하지 않음
			if (i == removeNode)
				continue;
			if (parentNode == -1)
				continue;
			childNodeList[parentNode].add(i);
			cntChild[parentNode]++;
		}

		removeTree(removeNode);

		int answer = 0;
		for (int cnt : cntChild) {
			if (cnt == 0)
				answer++;
		}

		System.out.println(answer);
	}

	// dfs 방식으로 노드를 제거
	static void removeTree(int removeNode) {
		cntChild[removeNode] = -1;
		for (int node : childNodeList[removeNode]) {
			if (childNodeList[node].isEmpty()) {
				cntChild[node] = -1; // 제거된 노드는 -1을 넣어준다.
			} else {
				removeTree(node);
			}
		}
	}
}
