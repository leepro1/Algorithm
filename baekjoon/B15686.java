//https://www.acmicpc.net/problem/15686
/*
 * 치킨 배달 - 백트래킹
 * 치킨 거리는 x좌표의 차 + y좌표의 차 로 구하고, 모든 집들의 치킨거리의 합을 도시의 치킨 거리라 하자
 * M개의 치킨집을 남겨두어야한다. M개를 골라서 나머지를 제외하고 도시의 치킨 거리를 구해보며 최소값을 구해보자
 * Exception in thread "main" java.lang.ArrayStoreException: java.lang.Integer
 * -> Arrays.fill은 1차원 배열에서만 사용가능
 * 
 * 위의 시도가 시간초과로 틀렸다 -> map배열에서 value가 0인(집x,치킨집x) 것을 무시하기 위해 arrayHome배열을 만들자
 * 시간초과의 원인은 dfs함수를 재귀로 풀 때 파라미터에 i+1대신 start+1을 넣었기 때문이다. -> 가지치기 실패
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B15686 {
	static int n, m;
	static int[][] map;
	static boolean[] visited;
	static ArrayList<Node> arrayChicken = new ArrayList<>(); // 모든 치킨집의 좌표를 저장하는 배열
	static ArrayList<Node> arrayHome = new ArrayList<>(); // 모든 집의 좌표를 저장하는 배열
	static int min = Integer.MAX_VALUE;

	static class Node {
		int r;
		int c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					arrayHome.add(new Node(i, j));
				} else if (map[i][j] == 2) {
					arrayChicken.add(new Node(i, j));
				}
			}
		}
		visited = new boolean[arrayChicken.size()];

		dfs(0, 0);

		System.out.println(min);
	}

	static void dfs(int start, int depth) {
		if (depth == m) {
			calDistance();
			return;
		}

		for (int i = start; i < arrayChicken.size(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(i + 1, depth + 1);
				visited[i] = false;
			}
		}
	}

	static void calDistance() {
		int sum = 0; // 도시의 치킨 거리

		for (int i = 0; i < arrayHome.size(); i++) {
			int tempSum = Integer.MAX_VALUE;

			for (int j = 0; j < arrayChicken.size(); j++) {
				if (visited[j]) {
					int tempDistance = Math.abs(arrayChicken.get(j).r - arrayHome.get(i).r)
							+ Math.abs(arrayChicken.get(j).c - arrayHome.get(i).c);
					tempSum = Math.min(tempSum, tempDistance);
				}
			}
			sum += tempSum;
		}

		min = Math.min(sum, min);
	}
}
