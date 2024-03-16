package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class B16953 {
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		if (end % 10 % 2 == 1 && (end % 10) != 1) {
			System.out.println(-1);
			System.exit(0);
		}

		bfs();
	}

	static void bfs() {
		Queue<int[]> queue = new ArrayDeque<>();
		queue.add(new int[] { start, 1 });

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();

			if (temp[0] == end) {
				System.out.println(temp[1]);
				return;
			}

			if ((temp[0] < temp[0] * 10 + 1) && (temp[0] * 10 + 1 <= end)) {
				queue.add(new int[] { temp[0] * 10 + 1, temp[1] + 1 });
			}
			if ((temp[0] < temp[0] * 2) && (temp[0] * 2 <= end)) {
				queue.add(new int[] { temp[0] * 2, temp[1] + 1 });
			}
		}

		System.out.println(-1);
	}
}
