//https://www.acmicpc.net/problem/16234
/*
 * 인구 이동 - 시뮬레이션, BFS
 * 배열의 모든 요소를 탐색하여 국경선이 열리는 지 조사한다. BFS로 탐색을 한다.
 * 반복하면서 인구이동의 여부를 확인하고 반복할 때마다 +1일은 한다.
 * 이동이 안될 때 종료
 */
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16234 {
	private static int n, l, r;
	private static int[][] matrix;
	private static boolean[][] visited;
	private static int[] dx = { 1, -1, 0, 0 };
	private static int[] dy = { 0, 0, 1, -1 };
	private static Queue<int[]> queue = new LinkedList<int[]>();
	private static LinkedList<int[]> list = new LinkedList<int[]>(); // 연합인 국가를 임시 저장해둘 list
	private static boolean flag; // 인구 이동을 했다는 것을 check할 변수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken()); // 공유가능 하한선
		r = Integer.parseInt(st.nextToken()); // 공유가능 상한선

		matrix = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0; // 인구 이동이 일어나는 날짜 수를 셀 변수
		while (true) {
			visited = new boolean[n][n];
			flag = false;

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}
			if (!flag)
				break;
			cnt++;
		}

		System.out.println(cnt);
	}

	private static void bfs(int x, int y) {
		queue.offer(new int[] { x, y });
		visited[x][y] = true;
		list.add(new int[] { x, y });
		int sumOfPopulation = matrix[x][y];

		while (!queue.isEmpty()) {
			int temp[] = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = temp[0] + dx[i];
				int nextY = temp[1] + dy[i];

				if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
					continue;

				if (visited[nextX][nextY])
					continue;

				// 연합에 포함될 때
				if (Math.abs(matrix[nextX][nextY] - matrix[temp[0]][temp[1]]) >= l
						&& Math.abs(matrix[nextX][nextY] - matrix[temp[0]][temp[1]]) <= r) {
					visited[nextX][nextY] = true;
					queue.offer(new int[] { nextX, nextY });
					list.add(new int[] { nextX, nextY });
					sumOfPopulation += matrix[nextX][nextY];
				}
			}
		}

		// 연합이 만들어졌을 때 인구이동한다.
		if (list.size() > 1) {
			move(sumOfPopulation / list.size());
			flag = true;
		}

		sumOfPopulation = 0;
		list.clear();
	}

	// 인구이동을 하는 함수
	private static void move(int avg) {
		for (int[] temp : list) {
			matrix[temp[0]][temp[1]] = avg;
		}
	}
}
