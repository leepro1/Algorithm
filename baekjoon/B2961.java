package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
	static int n;
	static int[] s, b;
	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		s = new int[n];
		b = new int[n];
		visited = new boolean[n];

		// 신맛은 사용한 신맛의 곱, 쓴맛은 사용한 쓴맛은 합이다.
		StringTokenizer st;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			s[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}

		subset(0);

		System.out.println(answer);
	}

	public static void subset(int depth) {
		if (depth == n) {
			int mul = 1;
			int sum = 0;
			for (int i = 0; i < n; ++i) {
				if (visited[i]) {
					mul *= s[i];
					sum += b[i];
				}
			}

			// 아무 음식도 선택하지 않은 경우
			if (sum == 0)
				return;
			
			answer = Math.min(answer, Math.abs(sum - mul));
			return;
		}
		visited[depth] = true;
		subset(depth + 1);
		visited[depth] = false;
		subset(depth + 1);
	}

}
