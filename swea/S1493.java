package swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1493 {
	static int[][] coordinate;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		coordinate = new int[300][300];

		for (int i = 1; i < 300; i++) {
			coordinate[i][1] = coordinate[i - 1][1] + i - 1;
			if (i == 1)
				coordinate[i][1] = 1;
			for (int j = 2; j < 300; j++) {
				coordinate[i][j] = coordinate[i][j - 1] + i + j - 1;
			}
		}

		int p, q;
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			q = Integer.parseInt(st.nextToken());

			Node node1 = toPoint(p);
			Node node2 = toPoint(q);

			sb.append("#" + t + " " + coordinate[node1.x + node2.x][node1.y + node2.y] + "\n");
		}

		System.out.println(sb);
	}

	static Node toPoint(int value) {
		for (int i = 1; i < 300; i++) {
			for (int j = 1; j < 300; j++) {
				if (coordinate[i][j] == value)
					return new Node(i, j);
			}
		}
		return null;
	}

	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
