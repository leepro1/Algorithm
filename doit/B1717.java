/*
 * https://www.acmicpc.net/problem/1717
 * 집합의 표현
 * 합진합 연산과 집합판별연산을 해야하므로 union-find 알고리즘을 사용한다.
 */
package doit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		for (int i = 0; i <= n; i++) {
			parent[i] = i;
		}

		StringBuilder sb = new StringBuilder();
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int operation = Integer.parseInt(st.nextToken());
			int node1 = Integer.parseInt(st.nextToken());
			int node2 = Integer.parseInt(st.nextToken());

			if (operation == 0) {
				union(node1, node2);
			} else {
				if (find(node1) == find(node2))
					sb.append("YES\n");
				else
					sb.append("NO\n");
			}
		}
		System.out.println(sb);
	}

	static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	static int find(int x) {
		if (parent[x] == x)
			return x;
		return parent[x] = find(parent[x]);
	}
}
