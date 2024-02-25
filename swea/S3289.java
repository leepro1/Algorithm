package swea;

//수행시간:425ms       메모리:107,912kb
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3289 {
	static int[] parent;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#" + test_case + " ");

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			parent = new int[N + 1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}

			int oper, x, y;
			while (M-- > 0) {
				st = new StringTokenizer(br.readLine());

				oper = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				if (oper == 0)
					union(x, y);
				else {
					if (find(x) == find(y))
						sb.append(1);
					else
						sb.append(0);
				}
			}

			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;

		return parent[x] = find(parent[x]);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}
}
