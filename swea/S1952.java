package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1952 {
	static int[] price = new int[4];
	static int[] usePlan = new int[12];
	static int answer;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < 4; i++) {
				price[i] = Integer.parseInt(st.nextToken());
			}

			answer = price[3]; // 1년권 초기화

			st = new StringTokenizer(br.readLine());

			// 각 달마다 1일권과 1달권 비교하여 usePlan => 1달 소비계획으로 바꾸는 로직
			for (int i = 0; i < 12; i++) {
				usePlan[i] = Integer.parseInt(st.nextToken());
				usePlan[i] = Math.min(price[1], usePlan[i] * price[0]);
			}

			visited = new boolean[12];
			subset(0);

			sb.append("#" + t + " " + answer + "\n");
		}

		System.out.println(sb);
	}

	public static void subset(int depth) {
		if (depth == 12) {
			int sum = 0;
			for (int i = 0; i < 12; i++) {
				if (visited[i]) {
					i += 2;
					sum += price[2];
				} else {
					sum += usePlan[i];
				}
			}

			answer = Math.min(answer, sum);
			return;
		}

		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}
}
