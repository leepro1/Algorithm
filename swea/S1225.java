package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class S1225 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = 10;

		int n;
		boolean flag;
		Queue<Integer> queue;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			n = Integer.parseInt(br.readLine());

			queue = new LinkedList<Integer>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
			}

			flag = true;

			while (flag) {
				for (int i = -1; i >= -5; i--) {
					int temp = queue.poll();
					if (temp + i <= 0) {
						queue.offer(0);
						flag = false;
						break;
					} else {
						queue.offer(temp + i);
					}
				}
			}

			// 출력부
			sb.append("#" + n + " ");
			for (int i = 0; i < 8; i++) {
				sb.append(queue.poll() + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}