package swea;

//수행시간:208ms       메모리:38,672kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class S2382 {

	static int N, M, K;
	static int[][][] map;
	static Node[] nodeList;

	// 상, 좌, 하, 우
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, -1, 0, 1 };

	static class Node {
		int x, y, cnt, diretion, sum;

		public Node(int x, int y, int cnt, int diretion) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.diretion = diretion;
			this.sum = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N][2];
			nodeList = new Node[K + 1];
			for (int i = 1; i <= K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int direction = Integer.parseInt(st.nextToken());

				switch (direction) {
				case 1:
					direction = 0;
					break;
				case 2:
					direction = 2;
					break;
				case 3:
					direction = 1;
					break;
				case 4:
					direction = 3;
					break;
				}

				nodeList[i] = new Node(x, y, cnt, direction);

				map[x][y][0] = i;
			}

			solve(0, 0);

			int sum = 0;
			for (int i = 1; i <= K; i++) {
				if (nodeList[i] != null)
					sum += nodeList[i].cnt;
			}

			sb.append("#" + t + " " + sum + "\n");
		}
		System.out.println(sb);
	}

	static void solve(int depth, int flag) {
		if (depth == M)
			return;

		Queue<Integer> winnerList = new ArrayDeque<>();
		for (int i = 1; i <= K; i++) {
			if (nodeList[i] == null)
				continue;

			map[nodeList[i].x][nodeList[i].y][flag % 2] = 0;
			nodeList[i].x += dx[nodeList[i].diretion];
			nodeList[i].y += dy[nodeList[i].diretion];

			// 가장자리 처리
			if (nodeList[i].x == 0 || nodeList[i].y == 0 || nodeList[i].x == N - 1 || nodeList[i].y == N - 1) {
				nodeList[i].cnt /= 2;
				nodeList[i].diretion = (nodeList[i].diretion + 2) % 4;

				if (nodeList[i].cnt == 0) {
					nodeList[i] = null;
					continue;

				}
				map[nodeList[i].x][nodeList[i].y][(flag + 1) % 2] = i;

				continue;
			}

			if (map[nodeList[i].x][nodeList[i].y][(flag + 1) % 2] == 0) {
				map[nodeList[i].x][nodeList[i].y][(flag + 1) % 2] = i;
				map[nodeList[i].x][nodeList[i].y][flag % 2] = 0;
			} else {
				int temp = map[nodeList[i].x][nodeList[i].y][(flag + 1) % 2];
				int winner = nodeList[i].cnt > nodeList[temp].cnt ? i : temp;
				int loser = nodeList[i].cnt < nodeList[temp].cnt ? i : temp;
				winnerList.add(winner);

				map[nodeList[i].x][nodeList[i].y][(flag + 1) % 2] = winner;
				nodeList[winner].sum += nodeList[loser].sum + nodeList[loser].cnt;
				map[nodeList[i].x][nodeList[i].y][flag % 2] = 0;
				nodeList[loser] = null;
			}
		}

		while (!winnerList.isEmpty()) {
			int winner = winnerList.poll();

			if (nodeList[winner] == null)
				continue;

			nodeList[winner].cnt += nodeList[winner].sum;
			nodeList[winner].sum = 0;
		}

		solve(depth + 1, flag + 1);
	}
}
