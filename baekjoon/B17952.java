package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B17952 {
	static int N, answer = 0;
	static ArrayDeque<Work> list = new ArrayDeque<>();

	static class Work {
		int score;
		int time;

		public Work(int score, int time) {
			this.score = score;
			this.time = time;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			if (st.nextToken().equals("0")) {
				if (list.isEmpty())
					continue;

				if (--list.getFirst().time == 0) {
					answer += list.pollFirst().score;
				}
			} else {
				int A = Integer.parseInt(st.nextToken());
				int T = Integer.parseInt(st.nextToken());

				if (--T == 0) {
					answer += A;
					continue;
				}

				list.addFirst(new Work(A, T));
			}
		}

		System.out.println(answer);
	}
}
