package swea;

//수행시간:111ms       메모리:18,280kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_D4_Contact_이희주 {
	static int N, start, answer;
	static boolean[] visited;
	static ArrayList<Integer>[] nodeList;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()) / 2;
			start = Integer.parseInt(st.nextToken());

			nodeList = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				nodeList[i] = new ArrayList<>();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				nodeList[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
			}

			visited = new boolean[101];

			bfs();

			// 출력부
			sb.append("#" + test_case + " " + answer + " \n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { start, 0 });
		visited[start] = true;

		int cnt = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();

			if (now[1] > cnt) {
				answer = 0;
				cnt++;
			}
			if (now[1] == cnt) {
				answer = Math.max(answer, now[0]);
			}

			for (int next : nodeList[now[0]]) {
				if (!visited[next]) {
					queue.add(new int[] { next, now[1] + 1 });
					visited[next] = true;
				}
			}
		}

	}
}
