package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2042 {
	static int N, M, K;
	static long[] arr;
	static long[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new long[N + 1];
		tree = new long[N << 2];

		for (int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		init(1, N, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M + K; i++) {
			st = new StringTokenizer(br.readLine());

			// 1일 때 update, 2일 때 sum
			if (Integer.parseInt(st.nextToken()) == 1) {
				// diff 말고 val로 구현
				update(1, N, 1, Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken()));
			} else {
				sb.append(sum(1, N, 1, Integer.parseInt(st.nextToken()), Long.parseLong(st.nextToken())) + "\n");
			}
		}

		System.out.println(sb);
	}

	public static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = arr[start];

		int mid = (start + end) >> 1;
		return tree[node] = init(start, mid, 2 * node) + init(mid + 1, end, 2 * node + 1);
	}

	public static long sum(int start, int end, int node, int left, long right) {
		if (right < start || left > end)
			return 0L;

		if (left <= start && right >= end) {
			return tree[node];
		}

		int mid = (start + end) >> 1;
		return sum(start, mid, 2 * node, left, right) + sum(mid + 1, end, 2 * node + 1, left, right);
	}

	public static void update(int start, int end, int node, int index, long val) {
		if (start == end) {
			arr[index] = val;
			tree[node] = arr[index];
			return;
		}

		int mid = (start + end) >> 1;
		if (start <= index && index <= mid)
			update(start, mid, 2 * node, index, val);
		else
			update(mid + 1, end, 2 * node + 1, index, val);

		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}
}
