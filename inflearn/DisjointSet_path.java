package inflearn;

import java.util.Arrays;

public class DisjointSet_path {
	static int N;
	static int[] parent;

	public static void makeSet() {
		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}
	}

	public static int find(int x) {
		if (x == parent[x])
			return x;

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x <= y)
			parent[y] = x;
		else
			parent[x] = y;
	}

	public static void main(String[] args) {
		N = 6;
		makeSet();
		System.out.println(Arrays.toString(parent));

		union(1, 2);
		System.out.println(Arrays.toString(parent));
		union(3, 4);
		System.out.println(Arrays.toString(parent));
		union(1, 5);
		System.out.println(Arrays.toString(parent));
		union(3, 5);
		System.out.println(Arrays.toString(parent));
		find(4);
		System.out.println(Arrays.toString(parent));
	}
}