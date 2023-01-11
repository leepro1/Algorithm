//https://www.acmicpc.net/problem/1717
package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		parent = new int[n + 1];

		while (n > 0){
			makeSet(n);
			n--;
		}

		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			if (order == 0) {
				union(x, y);
			} 
			else {
				if (findSet(x) == findSet(y))
					System.out.println("YES");
				else {
					System.out.println("NO");
				}
			}
		}
	}

	private static void makeSet(int x) {
		parent[x] = x;
	}

	private static int findSet(int x) {
		if (parent[x] != x)
			parent[x] = findSet(parent[x]);

		return parent[x];
	}

	private static void union(int x, int y) {
		x = findSet(x);
		y = findSet(y);

		if (x != y)
			parent[y] = x;
	}
}
