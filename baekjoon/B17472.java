package baekjoon;

//수행시간:164ms       메모리:16,304kb
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.IOException;

public class B17472 {
	static int N, M, cnt;
	static int[][] matrix;
	static int[][] costMatrix;
	static boolean[] visited;

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	static Queue<Vertex> queue = new ArrayDeque<>();
	static PriorityQueue<Edge> pq = new PriorityQueue<>();

	static class Vertex {
		int x;
		int y;

		public Vertex(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int cost;

		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		matrix = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				if (st.nextToken().equals("0"))
					matrix[i][j] = 0;
				else
					matrix[i][j] = -1;
			}
		}

		// 섬에 index 부여
		cnt = 1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] == -1)
					bfs(i, j, cnt++);
			}
		}

		// 비용 배열 초기화
		costMatrix = new int[cnt][cnt];
		for (int i = 1; i < cnt; i++) {
			for (int j = 1; j < cnt; j++) {
				costMatrix[i][j] = Integer.MAX_VALUE;
			}
		}

		// 간선 만들기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (matrix[i][j] != 0)
					makeEdge(i, j);
			}
		}

		// 프림 알고리즘
		int linkCnt = cnt - 1;
		visited = new boolean[cnt];
		addEdge(1);

		int sum = 0;
		while (!pq.isEmpty()) {
			Edge tempEdge = pq.poll();
			if (visited[tempEdge.end])
				continue;

			addEdge(tempEdge.end);
			sum += tempEdge.cost;
			linkCnt--;

			if (linkCnt == 1) {
				System.out.println(sum);
				System.exit(0);
			}
		}

		System.out.println(-1);
	}

	static void bfs(int i, int j, int cnt) {
		queue.add(new Vertex(i, j));
		matrix[i][j] = cnt;

		while (!queue.isEmpty()) {
			Vertex v = queue.poll();

			for (int k = 0; k < 4; k++) {
				int nextX = v.x + dx[k];
				int nextY = v.y + dy[k];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || matrix[nextX][nextY] == 0
						|| matrix[nextX][nextY] == cnt)
					continue;

				queue.add(new Vertex(nextX, nextY));
				matrix[nextX][nextY] = cnt;
			}
		}
	}

	static void makeEdge(int x, int y) {
		for (int k = 0; k < 4; k++) {
			int tempCnt = 0;

			int nextX = x + dx[k];
			int nextY = y + dy[k];

			while (true) {
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M || matrix[x][y] == matrix[nextX][nextY])
					break;

				if (matrix[nextX][nextY] != 0) {
					if (tempCnt <= 1)
						break;

					costMatrix[matrix[x][y]][matrix[nextX][nextY]] = Math
							.min(costMatrix[matrix[x][y]][matrix[nextX][nextY]], tempCnt);
					costMatrix[matrix[nextX][nextY]][matrix[x][y]] = Math
							.min(costMatrix[matrix[nextX][nextY]][matrix[x][y]], tempCnt);
					break;
				}

				nextX += dx[k];
				nextY += dy[k];
				tempCnt++;
			}
		}
	}

	static void addEdge(int start) {
		visited[start] = true;

		for (int i = 1; i < cnt; i++) {
			if (costMatrix[start][i] != Integer.MAX_VALUE && !visited[i])
				pq.add(new Edge(start, i, costMatrix[start][i]));
		}
	}
}
