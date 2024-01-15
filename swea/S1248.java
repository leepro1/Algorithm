package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1248 {
	static int[][] child;
	static int cnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int v, e, node1, node2;
		int tempParent, tempChild;
		int[] parent;
		boolean[] nodeParent;

		int common;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			v = Integer.parseInt(st.nextToken());
			e = Integer.parseInt(st.nextToken());
			node1 = Integer.parseInt(st.nextToken());
			node2 = Integer.parseInt(st.nextToken());

			parent = new int[v + 1];
			parent[0] = parent[1] = 0;

			child = new int[v + 1][2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < e; i++) {
				tempParent = Integer.parseInt(st.nextToken());
				tempChild = Integer.parseInt(st.nextToken());

				parent[tempChild] = tempParent;

				if (child[tempParent][0] == 0) {
					child[tempParent][0] = tempChild;
				} else {
					child[tempParent][1] = tempChild;
				}
			}

			// node1의 조상 등록
			nodeParent = new boolean[v + 1];
			for (int startNode = node1; startNode != 0;) {
				nodeParent[startNode] = true;
				startNode = parent[startNode];
			}

			// 공통 조상 찾기
			common = 0;
			for (int startNode = node2; startNode != 0;) {
				if (nodeParent[startNode]) {
					common = startNode;
					break;
				} else {
					startNode = parent[startNode];
				}
			}

			// 서브 트리 크기
			cnt = 1;
			countNode(common);

			sb.append("#" + t + " " + common + " " + cnt + "\n");
		}
		System.out.println(sb);
	}

	static void countNode(int node) {
		if (child[node][0] == 0 && child[node][1] == 0) {
			return;
		}
		if (child[node][0] != 0) {
			cnt++;
			countNode(child[node][0]);
		}
		if (child[node][1] != 0) {
			cnt++;
			countNode(child[node][1]);
		}
	}
}
