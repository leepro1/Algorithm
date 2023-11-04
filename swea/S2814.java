package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S2814 {
	static int cnt, max;
	static boolean[] visited;
	static ArrayList<Integer>[] nodeList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int n, m;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			visited = new boolean[n + 1];
			nodeList = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				nodeList[i] = new ArrayList<>();
			}

			// 간선 정보
			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				nodeList[x].add(y);
				nodeList[y].add(x);
			}

			max = 0;
			for (int i = 1; i <= n; i++) {
				cnt = 1;
				visited[i] = true;
				dfs(i);
				visited[i] = false;
			}

			sb.append("#" + t + " " + max + "\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int start) {
		max = Math.max(max, cnt);
		for (int node : nodeList[start]) {
			if (!visited[node]) {
				visited[node] = true;
				cnt++;
				dfs(node);
				visited[node] = false;
				cnt--;
			}
		}
	}
}
