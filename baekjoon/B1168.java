package baekjoon;

//수행시간:396ms       메모리:33,444kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1168 {
	static int N, M;
	static long[] tree;
	static StringBuilder sb = new StringBuilder("<");

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		tree = new long[N << 2];

		init(1, N, 1);

		int tempIndex = M;
		for (int i = 1; i <= N; i++) {
			update(1, N, 1, tempIndex, 0);

			if (tree[1] == 0)
				break;

			tempIndex = (int) ((tempIndex + M - 1) % tree[1]);
			if (tempIndex == 0)
				tempIndex = (int) tree[1];
		}

		sb.replace(sb.length() - 2, sb.length(), ">");
		System.out.println(sb);
	}

	public static long init(int start, int end, int node) {
		if (start == end)
			return tree[node] = 1;

		int mid = (start + end) >> 1;
		return tree[node] = init(start, mid, 2 * node) + init(mid + 1, end, 2 * node + 1);
	}

	public static void update(int start, int end, int node, int index, int val) {
		if (start == end) {
			sb.append(start + ", ");
			tree[node] = val;
			return;
		}

		int mid = (start + end) >> 1;
		if (index <= tree[2 * node])
			update(start, mid, 2 * node, index, val);
		else {
			update(mid + 1, end, 2 * node + 1, index - (int) tree[2 * node], val);
		}

		tree[node] = tree[2 * node] + tree[2 * node + 1];
	}
}
