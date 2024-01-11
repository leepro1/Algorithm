package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static boolean[] visited;
	static Node company, home;
	static Node[] clientList;
	static int[][] distArr;
	static int answer;

	static class Node {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			clientList = new Node[n];

			// 위치 입력부
			for (int i = 0; i < n + 2; i++) {
				if (i == 0) {
					company = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else if (i == 1) {
					home = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				} else {
					clientList[i - 2] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}
			}

			// 각 client 사이의 거리를 저장하는 배열
			distArr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (i == j)
						distArr[i][j] = 0;
					else
						distArr[i][j] = calDistance(clientList[i], clientList[j]);
				}
			}

			answer = Integer.MAX_VALUE;

			// 모든 경우의 수 위치 계산 로직
			visited = new boolean[n];
			for (int i = 0; i < n; i++) {
				visited[i] = true;
				dfs(i, calDistance(company, clientList[i]), 1);
				visited[i] = false;
			}

			sb.append("#" + t + " " + answer + "\n");
		}
		System.out.println(sb);
	}

	// 거리 계산 로직
	static int calDistance(Node node1, Node node2) {
		return Math.abs(node1.x - node2.x) + Math.abs(node1.y - node2.y);
	}

	// 모든 노드 경로 탐색 로직
	static void dfs(int startIndex, int tempDist, int depth) {
		if (depth == n) {
			tempDist += calDistance(clientList[startIndex], home);
			answer = Math.min(answer, tempDist);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i, tempDist + distArr[startIndex][i], depth + 1);
				visited[i] = false;
			}
		}
	}
}